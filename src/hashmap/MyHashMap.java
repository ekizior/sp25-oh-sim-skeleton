package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {
    @Override
    public void put(K key, V value) {
        
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private List<Node>[] buckets;
    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static final double DEFAULT_LOAD_FACTOR = 0.75;

    /**
     * Constructs a new MyHashMap with DEFAULT_INITIAL_CAPACITY buckets and
     * DEFAULT_LOAD_FACTOR maximum load factor.
     */
    public MyHashMap() {

    }

    /**
     * Constructs a new MyHashMap with specified initialCapacity buckets and
     * maxLoadFactor load factor.
     */
    public MyHashMap(int initialCapacity, double maxLoadFactor) {

    }

    // Implement methods from the Map61B interface below
}
