package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy{
    final static int DEFAULT_INITIAL_CAPACITY = 16;
    final static float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null) return Boolean.parseBoolean( null );

        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i]; e != null; e = e.next)
                if (value.equals( e.value ))
                    return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash( (long) key.hashCode() );
            int i = indexFor(hash, table.length);
            for (Entry entry = table[i]; entry != null; entry = entry.next) {
                Object k;
                if (entry.hash == hash && ((k = entry.key) == key || key.equals(k))) {
                    String oldValue = entry.value;
                    entry.value = value;
                    return;
                }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for(Entry entry = tab[i]; entry != null; entry = entry.next){
                if (entry.getValue().equals(value)) return entry.getKey();
            }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (this.containsKey(key)) {
            return getEntry(key).getValue();
        }
        return null;
    }

    int hash(Long k){
        int result = 17;
        return result*32 + (int) (k - (k<<32));
    }

    int indexFor(int hash, int length)
    {
        return hash & (length - 1);
    }

    final Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry entry = table[indexFor(hash, table.length)]; entry != null; entry = entry.next){
            Object o;
            if (entry.hash == hash && ((o = entry.key) == key || (key != null && key.equals(o))))
                return entry;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == DEFAULT_INITIAL_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    void transfer(Entry[] newTable){
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int i = 0; i < newTable.length; i++){
            Entry entry = src[i];
            if (entry != null){
                src[i] = null;
                do{
                    Entry next = entry.next;
                    int index = indexFor(next.hash, newCapacity);
                    entry.next = newTable[i];
                    newTable[i] = entry;
                    entry = next;
                } while (entry != null);
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        size++;
    }

}
