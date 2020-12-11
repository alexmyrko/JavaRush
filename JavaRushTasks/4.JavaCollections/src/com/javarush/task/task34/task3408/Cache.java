package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) {
        //TODO add your code here
        V value = cache.get(key);
        if (value == null) {

            Constructor constructor = null;
            V instance = null;
            try {
                constructor = clazz.getDeclaredConstructor(key.getClass());
                 instance = (V) constructor.newInstance(key);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            } catch (NoSuchMethodException e) {
            }
            value = cache.put(key, instance);
        }
        return cache.get(key);
    }

    public boolean put(V obj) throws IllegalAccessException {
        //TODO add your code here
        Method method = null;
        K key = null;
        V value;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            key = (K) method.invoke(obj);
            value = cache.put(key, obj);
            V result = cache.get(key);
            if (result != null)
                return true;
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
