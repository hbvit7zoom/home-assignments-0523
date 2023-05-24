package ru.sberbank.jd.lesson06;

import java.util.Collection;

/**
 * Simple array. Can store any objects.
 */
public interface CustomArray<T> {

    int size();

    boolean isEmpty();

    /**
     * Add single item.
     */
    boolean add(T item);

    /**
     * Add all items.
     *
     * @throws IllegalArgumentException if parameter items is null
     */
    boolean addAll(T[] items);

    /**
     * Add all items.
     *
     * @throws IllegalArgumentException if parameter items is null
     */
    boolean addAll(Collection<T> items);

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    boolean addAll(int index, T[] items);

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    T get(int index);

    /**
     * Set item by index.
     *
     * @param index - index
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    T set(int index, T item);

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    void remove(int index);

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    boolean remove(T item);

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    boolean contains(T item);

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    int indexOf(T item);

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    void ensureCapacity(int newElementsCount);

    /**
     * Get current capacity.
     */
    int getCapacity();

    /**
     * Reverse list.
     */
    void reverse();

    /**
     * Get content in format '[ element1 element2 ... elenentN ] or [ ] if empty.
     */
    String toString();

    /**
     * Get copy of current array.
     */
    Object[] toArray();
}

