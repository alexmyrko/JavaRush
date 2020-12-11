package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;
    public AmigoSet(){
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        float floatCapacity = collection.size()/0.75f;
        int capacity = (int) Math.ceil((double) floatCapacity);
        map = new HashMap<>(Math.max(16, capacity));
        boolean res;
        for (E e : collection)
            map.put(e, PRESENT);
    }

    public static void main(String[] args) {

    }

    @Override
    public boolean add(E e){
        return null == map.put((E) e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public boolean contains(Object o){
        return map.containsKey((E) o);
    }

    public void clear(){
        map.clear();
    }

    public boolean remove(Object o){
        return null == map.remove((E) o);
    }

    public Object clone() throws InternalError{
        try {
            AmigoSet<E> copy = (AmigoSet<E>) super.clone();
            copy.map = (HashMap<E, Object>) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        outputStream.writeObject(loadFactor);
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        outputStream.writeObject(capacity);
        Set<E> set = map.keySet();
        outputStream.writeObject(map.keySet().size());
        System.out.println(map.keySet().size());
        for(E element : set){
            outputStream.writeObject(element);
        }
        System.out.println("Map Size " + map.size());
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        float loadFactor = (float) inputStream.readObject();
        int capacity = (int) inputStream.readObject();
        map = new HashMap<>(capacity, loadFactor);
        int setSize = (int) inputStream.readObject();
        System.out.println(setSize);
        for(int i = 0; i < setSize; i++){
            map.put((E) inputStream.readObject(), PRESENT);
        }
        System.out.println("MapSize: " + map.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmigoSet)) return false;
        if (!super.equals(o)) return false;
        AmigoSet<?> amigoSet = (AmigoSet<?>) o;
        return map.equals(amigoSet.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), map);
    }
}
