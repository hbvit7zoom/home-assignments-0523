package ru.sberbank.jd.lesson08;

/**
 * Custom tree map.
 */
public interface CustomTreeMap<K, V> {

    /**
     *  Get ize of map.
     *
     * @return - size of map
     */
    int size();

    /**
     * Check map is empty.
     *
     * @return - boolean value
     */
    boolean isEmpty();

    /**
     * Get item by key.
     *
     * @param key - key
     */
    V get(K key);

    /**
     * Add value by key.
     *
     * @return previous value or null
     */
    V put(K key, V value);

    /**
     * Remove item by key.
     *
     * @param key - key
     * @return deleted item or null if item with key doesn't exists
     */
    V remove(K key);

    /**
     * Checks if item exists by key.
     *
     * @param key - key
     * @return true or false
     */
    boolean containsKey(K key);

    /**
     * Checks if item exists by value.
     *
     * @param value - item
     * @return true or false
     */
    boolean containsValue(V value);

    /**
     * Get all keys.
     * Get content in format '[ key1, ..., keyN ] or [ ] if empty.
     */
    Object[] keys();

    /**
     * Get all values.
     * Get content in format '[ value1, ..., valueN ] or [ ] if empty.
     */
    Object[] values();
}
