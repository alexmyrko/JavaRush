package com.javarush.task.task14.task1421;

/**
 * Created by Alex on 19.12.2018.
 */
    public class Singleton {
        private static final Singleton instance = null;
        private Singleton() {
    }

        public static Singleton getInstance(){
            return instance;
    }
}
