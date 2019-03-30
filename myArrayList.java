package com.company;

public class myArrayList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private Object[] array_ = new Object[DEFAULT_CAPACITY];
    private int size_ = 0;

    public myArrayList(){
        size_ = 0;
    }

    public myArrayList(int capacity){
        Object[] newArray = new Object[capacity];
        array_ = newArray;
        size_ = 0;
    }

    public void add(T obj) {
        if(size_ == array_.length - 1) {
            Object[] newArray = new Object[(int)(array_.length * 1.5) + 1];
            System.arraycopy(array_, 0, newArray, 0, size_);
            array_ = newArray;
        }
        array_[size_] = obj;
        ++size_;
    }

    public void add(int index, T obj) {
        if(index == array_.length - 1) {
            Object[] newArray = new Object[(int)(array_.length * 1.5) + 1];
            System.arraycopy(array_, 0, newArray, 0, size_);
            array_ = newArray;
        }
        array_[index] = obj;
        ++size_;
    }


    public T get(int index) {
        if (index >= 0 && index <= size_)
            throw new ArrayIndexOutOfBoundsException("error");
        return (T) array_[index];
    }

    public int size() {
        return size_;
    }

    public T set(int index, T obj) {
        T tmp = (T) array_[index];
        if (index >= 0 && index <= size_)
            throw new ArrayIndexOutOfBoundsException("error");
        array_[index] = obj;
        return tmp;
    }

    public T remove(int index) {
        T tmp = get(index);
        for (int i = index; i < size_; ++i)
            array_[i] = array_[i + 1];
        array_[size_] = null;
        return tmp;
    }

    public void clear() {
        Object[] new_array = new Object[DEFAULT_CAPACITY];
        array_ = new_array;
        size_ = 0;
    }
}

