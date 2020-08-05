package com.javarush.task.task17.task1701_;

import java.util.ArrayList;
import java.util.List;

/* Заметки
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread (Runnable не является нитью),
которая в методе run 1000 раз (index = 0-999) сделает следующие действия:
2.1. используя метод addNote добавит заметку с именем [getName() + "-Note" + index], например, при index=4
"Thread-0-Note4"
2.2. используя метод removeNote удалит заметку
2.3. в качестве первого параметра в removeNote передай имя нити - метод getName()
*/

public class Solution {
    public static void main(String[] args) {
        NoteThread myThread1 = new NoteThread();
        NoteThread myThread2 = new NoteThread();
        NoteThread myThread3 = new NoteThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<String>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Thread{
        public NoteThread(){

        }
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++){
                try {
                    Note.addNote(getName() + "-Note " + i);
                    Note.removeNote(getName());
                } catch (Exception e){

                    System.out.println(e);
                }
            }
            System.out.println(Note.notes.size());
        }
    }

}