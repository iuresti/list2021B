package edu.uaslp.list.linkedlist;

import edu.uaslp.list.Iterator;
import edu.uaslp.list.List;

public class LinkedList <H> implements List<H> {
    private Node<H> head;
    private Node<H> tail;
    private int size;

    private class ForwardIterator implements Iterator<H> {
        private Node<H> currentNode;

        ForwardIterator(){
            currentNode = head;
        }

        @Override
        public H next() {
            H data = currentNode.data;

            currentNode = currentNode.next;

            return data;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private class ReverseIterator implements Iterator<H> {
        private Node<H> currentNode;

        ReverseIterator(){
            currentNode = tail;
        }

        @Override
        public H next() {
            H data = currentNode.data;

            currentNode = currentNode.previous;

            return data;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    public Iterator<H> getIterator(){
        return new ForwardIterator();
    }

    public Iterator<H> getReverseIterator(){
        return new ReverseIterator();
    }

    public void add(H dato) {
        Node<H> node = new Node<>();

        node.data = dato;

        if (head == null) {
            head = node;
        }

        node.previous = tail;

        if (tail != null) {
            tail.next = node;
        }

        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    public H getAt(int index) {
        int counter = 0;
        Node<H> it = head;

        while (counter < index && it != null) {
            counter++;
            it = it.next;
        }

        return it == null ? null : it.data;
    }

    public void delete(int index) {
        int counter = 0;
        Node<H> iterator = head;

        if (index < 0 || index >= size) {
            return;
        }

        while (counter < index && iterator != null) {
            iterator = iterator.next;
            counter++;
        }

        if (iterator.previous == null) {
            head = iterator.next;
        } else {
            iterator.previous.next = iterator.next;
        }

        if (iterator.next == null) {
            tail = iterator.previous;
        } else {
            iterator.next.previous = iterator.previous;
        }

        size--;
    }

    public void insert(H data, int index){
        int counter = 0;
        Node<H> iterator = head;

        if (index < 0 || index > size) {
            return;
        }

        if(index == size){
            add(data);
            return;
        }

        while (counter < index && iterator != null) {
            iterator = iterator.next;
            counter++;
        }

        Node<H> node = new Node<>();

        node.data = data;
        node.next = iterator;
        node.previous = iterator.previous;

        if(iterator.previous == null){
            head = node;
        } else {
            iterator.previous.next = node;
        }
        iterator.previous = node;
        size++;
    }
}
