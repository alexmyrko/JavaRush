package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        /*String line = "+38(050)123-45-67";
        line = line.replace("(", "");
        line = line.replace(")", "");
        line = line.replace("-", "");
        System.out.println("callto://" + line);
        for (Map.Entry entry : countries.entrySet()) {
            if (entry.getValue().equals("Ukraine"))
                System.out.println(String.valueOf(entry.getKey()));
        }*/
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        public String getCountryCode(){
            for (Map.Entry entry : countries.entrySet()){
                if (entry.getValue().equals(customer.getCountryName()))
                    return String.valueOf(entry.getKey());
            }
            return null;
        }
        public String getCompany(){
            return customer.getCompanyName();
        }
        public String getContactLastName(){
            return contact.getName().substring(0,contact.getName().indexOf(","));
        }
        public String getContactFirstName(){
            return contact.getName().substring(contact.getName().indexOf(" ") + 1, contact.getName().length());
        }
        public String getDialString(){
            String line = contact.getPhoneNumber();
            line = line.replace("(", "");
            line = line.replace(")", "");
            line = line.replace("-", "");
            return "callto://" + line;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}