package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public int hashCode(){
        int result = 17;
        return result * 37 + (int) (key - (key>>32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return key.equals(entry.key) &&
                value.equals(entry.value);
    }

    public boolean equals(){
        return this.equals(value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
