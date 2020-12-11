package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int amount = 0;
        withdraw:
        while (true) {
            ConsoleHelper.writeMessage("Enter amount:");
            try {
                amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    continue;
                }
                if (!manipulator.isAmountAvailable(amount)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
                HashMap<Integer, Integer> result = (HashMap<Integer, Integer>) manipulator.withdrawAmount(amount);
                for(Map.Entry<Integer, Integer> entry : result.entrySet()){
                    System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
                }
                break;
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue withdraw;
            }
            catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue withdraw;
            }
        }
        ConsoleHelper.writeMessage(res.getString("success.format"));
    }
}
