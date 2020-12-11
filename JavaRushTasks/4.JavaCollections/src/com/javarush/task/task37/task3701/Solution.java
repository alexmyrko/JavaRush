package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;

        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }

/*        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(iterator.next() + " ");
            count++;
            if (count == 10) {
                break;
            }
            if (count == 5)
                iterator.remove();
            if (count == 7)
                iterator.remove();
            if (count == 9)
                iterator.remove();
        }*/
    }

    public Iterator<T> iterator(){
        return new RoundIterator(super.iterator());
    }


    public class RoundIterator implements Iterator{
        int cursor = 0;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;
        Iterator<T> it;
        public RoundIterator(Iterator<T> it) {
            this.it = it;
        }

        @Override
        public T next() {
            if (!it.hasNext())
                it = Solution.super.iterator();
            return it.next();
        }

        public void remove() {
            if (it.hasNext())
                it.remove();
        }

        @Override
        public boolean hasNext() {
            return true;
        }
    }


}
