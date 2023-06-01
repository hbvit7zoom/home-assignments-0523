package ru.sberbank.jd.lesson06;

import java.util.Collection;

public class CustomLinkedList<T> implements CustomArray<T> {

    private Node<T> first;
    private Node<T> last;

    class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;
    }

    public CustomLinkedList() {

    }

    @Override
    public int size() {
        if (first != null) {
            Node<T> current = first;
            int size = 1;
            while (current.next != null) {
                size++;
                current = current.next;
            }
            return size;
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean add(T item) {
        if (first == null) {
            Node<T> tNode = new Node<>();
            tNode.value = item;
            tNode.previous = null;
            tNode.next = null;
            first = tNode;
            last = tNode;
        } else {
            Node<T> tNode = new Node<>();
            tNode.value = item;
            tNode.previous = last;
            tNode.next = null;
            last.next = tNode;
            last = tNode;
        }
        return true;
    }

    @Override
    public boolean addAll(T[] items) {
        if (items == null) {
            return false;
//            throw new RuntimeException("Array is Null");
        }
        for (T item: items) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<T> items) {
        if (items == null) {
            return false;
//            throw new RuntimeException("Array is Null");
        }
        for (T item: items) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, T[] items) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T item) {
        return null;
    }

    @Override
    public void remove(int index) {
        int currentIndex = 0;
        Node<T> current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node<T> previous = current.previous;
        Node<T> next = current.next;

        previous.next = next;
        next.previous = previous;
    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public int indexOf(T item) {
        return 0;
    }

    @Override
    public void ensureCapacity(int newElementsCount) {

    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public void reverse() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
