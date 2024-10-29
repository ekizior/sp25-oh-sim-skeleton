package hashmap;

public interface Map61B<K, V> {

    /** Associates the specified key to the specified value. If the
     * key is already contained in the map, updates the old value to
     * the specified value. */
    void put(K key, V value);

    /** Returns the value mapped by the specified key. If the map does
     * not contain the key, returns null. */
    V get(K key);

    /** Returns true if the map contains a mapping for the specified key,
     * otherwise returns false. */
    boolean containsKey(K key);

    /** Returns the number of key-value mappings stored in this map. */
    int size();
}
