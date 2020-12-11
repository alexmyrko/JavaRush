package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.isEmpty())
            ConsoleHelper.writeMessage(res.getString("no.money"));
        for(CurrencyManipulator manipulator : manipulators){
            if (manipulator.hasMoney())
                System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            else ConsoleHelper.writeMessage(res.getString("no.money"));;
        }
    }
}
