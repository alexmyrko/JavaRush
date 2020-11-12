package com.javarush.task.task30.task3008;

import java.io.Console;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Alex on 27.04.2020.
 */
public class Server {
    static ServerSocket serverSocket;
    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    private static class Handler extends Thread{
        Socket socket;  
        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run(){
                String userName = null;
                System.out.println("Встановлено зєднання" + socket.getRemoteSocketAddress());
                try (Connection connection = new Connection(socket)){
                    userName = serverHandshake(connection);
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                    notifyUsers(connection, userName);
                    serverMainLoop(connection, userName);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.\"");
                } catch  (ClassNotFoundException e){
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.\"");
                } finally {
                    if (userName != null){
                        connectionMap.remove(userName);
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    }
                    ConsoleHelper.writeMessage("Connection with remote adress removed");
                }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String name;
            Message receivedMessage;
            while(true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                receivedMessage = connection.receive();
                if (receivedMessage.getType() == MessageType.USER_NAME){
                    name = receivedMessage.getData();
                    if (!(name.equals("") || connectionMap.containsKey(name)))
                        break;
                }
            }
            connectionMap.put(name, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            String name;
            for(Map.Entry<String, Connection> pair : connectionMap.entrySet()){
                name = pair.getKey();
                if (!name.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = userName + ": " + message.getData();
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else ConsoleHelper.writeMessage("It's not a text");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Enter server port: ");
        int port = ConsoleHelper.readInt();
        serverSocket = new ServerSocket(port);
        try {
            while(true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (Exception e){
            System.out.println(e);
        }
        finally{
            serverSocket.close();
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Connection connection: connectionMap.values()
             ) {
            try {
                connection.send(message);
            } catch (IOException e){
                System.out.println("Cannot send message");
            }
        }
    }

}
