package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;

public class FileStorageStrategy implements StorageStrategy{
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    int size;
    long maxBucketSize;

    public FileStorageStrategy() throws IOException {
        for(int i = 0; i < table.length; ++i)
            table[i] = new FileBucket();
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) throws IOException {
        FileBucket bucket = table[bucketIndex];
        Entry entry = bucket.getEntry();
        bucket.putEntry(new Entry(hash, key, value, entry));
        size++;
        if (size >= bucketSizeLimit)
            resize(2 * table.length);
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;
            for(Entry entry = table[i].getEntry(); entry != null; entry = entry.next){
                if (value.equals(entry.value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        if (table[i] == null) {
            try {
                createEntry(hash, key, value, i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            for(Entry entry = table[i].getEntry(); entry != null; entry = entry.next) {
                Long k;
                if (entry.hash == hash && ((k = entry.key) == key || key.equals(k))){
                    entry.value = value;
                    return;
                }
            }
        }
        try {
            addEntry(hash, key, value, i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++){
            if (table[i] == null)
                continue;
            for(Entry entry = table[i].getEntry(); entry != null; entry = entry.next){
                if (entry.getValue().equals(value))
                    return entry.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).getValue();
    }

    int hash(Long k){
        int result = 17;
        return result*32 + (int) (k - (k<<32));
    }

    int indexFor(int hash, int length)
    {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key);
        for (Entry entry = table[indexFor(hash, table.length)].getEntry(); entry != null; entry = entry.next){
            Long k;
            if (entry.hash == hash && ((k = entry.key) == key || (key != null && key.equals(k))))
                return entry;
        }
        return null;
    }

    void resize(int newCapacity) throws IOException {
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (FileBucket bucket : newTable ){
            bucket = new FileBucket();
        }
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable){
        int newCapacity = newTable.length;
        for (int i = 0; i < table.length; i++){
            if (table[i] == null)
                continue;
            Entry entry = table[i].getEntry();
            while(entry != null){
                int index = indexFor(entry.hash, newCapacity);
                Entry next = entry.next;
                entry.next = newTable[index].getEntry();
                try {
                    newTable[index].putEntry(entry);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                entry = next;
            }
            table[i].remove();
            table[i] = null;
        }
    }


    void createEntry(int hash, Long key, String value, int bucketIndex) throws IOException {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    public FileBucket[] getTable() {
        return table;
    }

    public void setTable(FileBucket[] table) {
        this.table = table;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
