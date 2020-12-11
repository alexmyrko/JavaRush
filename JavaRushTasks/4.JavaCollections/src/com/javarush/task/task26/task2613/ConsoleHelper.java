package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));;
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String text;
        try{
            text = bis.readLine();
            if (text.toUpperCase().equals("EXIT"))
                throw new InterruptOperationException();
        } catch (Exception e){
            writeMessage(res.getString("the.end"));
            throw new InterruptOperationException();
        }
        return text;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        System.out.println(res.getString("choose.currency.code"));
        String currency = readString();
        while (currency.length() != 3){
            System.out.println(res.getString("invalid.data"));
            currency = readString();
        }
        return currency.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws Exception{
        String[] digits = null;
        while(true) {
            System.out.println(res.getString("choose.denomination.and.count.format"));
            digits = readString().split(" ");
            if (digits.length != 2)
                throw new IllegalArgumentException();
            Integer nominal = Integer.parseInt(digits[0]);
            Integer quantity = Integer.parseInt(digits[1]);
            if (nominal < 0 || quantity < 0)
                throw new IllegalArgumentException();
            break;
        }
        return digits;
    }

    public static Operation askOperation() throws InterruptOperationException{
        Operation operation;
        while (true) {
            writeMessage(res.getString("choose.operation"));
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                return operation;
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage("Try again !");
            }
        }
    }

    public static void printExitMessage(){
        writeMessage("Bye! Bye!");
    }
}
