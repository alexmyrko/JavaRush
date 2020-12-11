package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int count = 0;
        for(K key : map.keySet())
            count += map.get(key).size();
        return count;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        V val;
        if (values != null)
            val = values.get(values.size() - 1);
        else{
            val = null;
            values = new ArrayList<>();
        }
        if (values.size() < repeatCount)
            values.add(value);
        else {
            values.remove(0);
            values.add(value);
        }
        map.put(key, values);
        return val;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        V val;
        if (values == null) {
            return null;
        } else {
            val = values.get(0);
            values.remove(0);
        }
        if (values.size() == 0)
            map.remove(key, values);
        return val;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> list = new ArrayList<>();
        for (List<V> values : map.values())
            list.addAll(values);
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for (List<V> values : map.values())
            if (values.contains(value))
                return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}