package edu.uaslp.list;

public interface List<T> {

    void add(T dato);

    int getSize();

    T getAt(int index);

    void delete(int index);

    void insert(T data, int index);

    void print();
}
