package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

import java.io.ObjectInputStream;

public class CachingProxyRetriever implements Retriever{
    LRUCache cache = new LRUCache(10);
    Storage storage;
    OriginalRetriever retriever;

    public CachingProxyRetriever(Storage storage){
        this.storage = storage;
        retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object element = cache.find(id);
        if (element == null) {
            element = retriever.retrieve(id);
            cache.set(id, element);
        }
        return element;
    }
}
