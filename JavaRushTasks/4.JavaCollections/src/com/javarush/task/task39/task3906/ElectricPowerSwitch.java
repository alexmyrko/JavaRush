package com.javarush.task.task39.task3906;

public class ElectricPowerSwitch {
    private Switchable device;

    public ElectricPowerSwitch(Switchable device) {
        this.device = device;
    }

    public void press() {
        System.out.println("Power switch flipped.");
        if (device.isOn()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }
}
