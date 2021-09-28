package edu.uaslp.list.arraylist;

public class ArrayList<T> {

    private static final int INITIAL_SIZE = 2;

    private Object[] array;
    private int nextValid;

    public ArrayList() {
        array = new Object[INITIAL_SIZE];
    }

    public void add(T data) {

        if (nextValid >= array.length) {
            increaseArrayCapacity();
        }

        array[nextValid] = data;
        nextValid++;
    }

    public void delete(int index) {
        if (index < 0 || index >= nextValid) {
            return;
        }
        if (nextValid - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, nextValid - 1 - index);
        }
        nextValid--;
    }

    public void insert(T data, int index) {
        if (index < 0 || index > nextValid) {
            return;
        }

        if (nextValid >= array.length) {
            increaseArrayCapacity();
        }

        if (nextValid - index >= 0)
            System.arraycopy(array, index, array, index + 1, nextValid - index);

        array[index] = data;
        nextValid++;
    }

    public int getSize() {
        return nextValid;
    }

    public T getAt(int index) {
        if (index < 0 || index >= nextValid) {
            return null;
        }

        return (T) array[index];
    }

    public void print() {
        for (int i = 0; i < nextValid; i++) {
            System.out.println(array[i]);
        }
    }

    private void increaseArrayCapacity() {
        Object[] newArray = new Object[array.length * 2];

        System.arraycopy(array, 0, newArray, 0, array.length);

        array = newArray;
    }

}
