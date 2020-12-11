package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry root = new Entry("init");
    Queue<Entry<String>> queue = new LinkedList();
    int size = 0;
    boolean abilityToAddChildren = false;

    public CustomTree() {
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        renewQueue();
        return size;
    }

    public boolean add(String element){
        renewQueue();
        if (!abilityToAddChildren)
            enableAbilityToAdd();
        renewQueue();
        Entry newEntry = new Entry(element);
        while(!queue.isEmpty()){
            Entry entry = queue.poll();
            if (entry.availableToAddLeftChildren && entry.leftChild == null) {
                newEntry.parent = entry;
                entry.leftChild = newEntry;
                break;
            } else if (entry.availableToAddRightChildren && entry.rightChild == null){
                newEntry.parent = entry;
                entry.rightChild = newEntry;
                break;
            }
        }
        return true;
    }

    public String getParent(String s){
        renewQueue();
        String result = null;
        Entry<String> entry = null;
        while (!queue.isEmpty()){
            entry = queue.poll();
            if (entry.elementName.equals(s)) {
                result = entry.parent.elementName;
                break;
            }
        }
        return result;
    }

    public boolean remove(Object o){
        String value;
        try{
            value = (String) o;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
        renewQueue();
        Entry<String> entry = null;
        while(!queue.isEmpty()){
            entry = queue.poll();
            if (entry.elementName.equals(value)){
                Entry<String> parent = entry.parent;
                if (parent.leftChild == entry) {
                    parent.leftChild = null;
                    break;
                }
                else{
                    parent.rightChild = null;
                    break;
                }
            }
        }
        return true;
    }

    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }

    public void renewQueue(){
        Queue<Entry<String>> tempQueue = new LinkedList();
        tempQueue.add(root);
        abilityToAddChildren = false;
        size = 0;
        queue.clear();
        queue.add(root);
        while(!tempQueue.isEmpty()){
            Entry<String> entry = tempQueue.poll();
            if (entry.leftChild != null) {
                entry.availableToAddLeftChildren = false;
                queue.add(entry.leftChild);
                tempQueue.add(entry.leftChild);
                size++;
            }
            if (entry.rightChild != null){
                entry.availableToAddRightChildren = false;
                queue.add(entry.rightChild);
                tempQueue.add(entry.rightChild);
                size++;
            }
            if (entry.isAvailableToAddChildren())
                abilityToAddChildren = true;
        }
    }

    public void enableAbilityToAdd(){
        Entry<String> entry;
        while(!queue.isEmpty()) {
            entry = queue.poll();
            if (entry.leftChild == null)
                entry.availableToAddLeftChildren = true;
            if (entry.rightChild == null)
                entry.availableToAddRightChildren = true;
        }
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
