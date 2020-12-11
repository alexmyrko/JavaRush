package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command{
    boolean isValid = false;
    private ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        do{
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumber = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();
            if (cardNumber.length() != 12 || pin.length() != 4) {
                ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if(validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(pin)){
                isValid = true;
                ConsoleHelper.writeMessage(res.getString("success.format"));
            }
        }while(!isValid);
    }
}
