package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client{
    public class BotSocketThread extends SocketThread{
        public void run() {
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            System.out.println(message);
            String[] parsedMessage = message.split(":");
            if (parsedMessage.length != 2)
                return;
            String userName = parsedMessage[0];
            String text = parsedMessage[1].replace(" ", "");
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String pattern;
            switch(text){
                case ("дата"): pattern = "d.MM.YYYY";
                    break;
                case ("день"):  pattern = "d";
                    break;
                case ("месяц"):  pattern = "MMMM";
                    break;
                case ("год"):  pattern = "YYYY";
                    break;
                case ("время"):  pattern = "H:mm:ss";
                    break;
                case ("час"):  pattern = "H";
                    break;
                case ("минуты"):  pattern = "m";
                    break;
                case ("секунды"):  pattern = "s";
                    break;
                default: pattern = "";
            }
            if (!pattern.equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                sendTextMessage(String.format("Информация для %s: %s", userName, sdf.format(date)));
            }
        }
    }

    @Override
    public void run() {
    }

    protected SocketThread getSocketThread(){
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName(){
        int botNumber = (int) (Math.random() * 100);
        return String.format("date_bot_%d", botNumber);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
