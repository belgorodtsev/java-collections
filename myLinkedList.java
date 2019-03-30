package com.company;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class myLinkedList<T> {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T data, Node<T> next) {
            this.item = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<T> first_ = null;
    private Node<T> last_ = null;
    private int size_ = 0;

    public myLinkedList() {
        first_ = null;
        last_ = null;
        size_ = 0;
    }

    public void addFirst(T obj) {
        final Node<T> f = first_;
        final Node<T> newNode = new Node<>(null, obj, f);
        first_ = newNode;
        if (f == null)
            last_ = newNode;
        else
            f.prev = newNode;
        size_++;
    }

    public void addLast(T obj) {
        final Node<T> l = last_;
        final Node<T> newNode = new Node<>(l, obj, null);
        last_ = newNode;
        if (l == null)
            first_ = newNode;
        else
            l.next = newNode;
        size_++;
    }

    public boolean add(T obj) {
        addLast(obj);
        return true;
    }

    public int size() {
        return size_;
    }

    public T getFirst() {
        final Node<T> f = first_;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public T getLast() {
        final Node<T> l = last_;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    public T removeFirst() {
        final Node<T> f = first_;
        if (f == null)
            throw new NoSuchElementException();
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null;
        first_ = next;
        if (next == null)
            last_ = null;
        else
            next.prev = null;
        size_--;
        return element;
    }

    public T removeLast() {
        final Node<T> l = last_;
        if (l == null)
            throw new NoSuchElementException();
        final T element = l.item;
        final Node<T> prev = l.prev;
        l.item = null;
        l.prev = null;
        last_ = prev;
        if (prev == null)
            first_ = null;
        else
            prev.next = null;
        size_--;
        return element;
    }

    public T get(int index) {
        if (index >= 0 && index <= size_)
            throw new ArrayIndexOutOfBoundsException("error");

        Node<T> tmp = first_;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        return tmp.item;
    }

    public void clear() {
        for (Node<T> x = first_; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first_ = last_ = null;
        size_ = 0;
    }
}
