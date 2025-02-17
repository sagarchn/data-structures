package org.chn.utils.Collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public int size() {
        return size;
    }

    private static class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        Node(T val) {
            this.val = val;
        }


    }

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }


    public void addLast(T elem) {
        if (isEmpty()) {
            first = new Node<>(elem);
            last = first;
            size++;
            return;
        }

        Node<T> node = new Node<>(elem);
        node.prev = last;
        last.next = node;
        last = node;
        size++;
    }


    public void addFirst(T elem) {
        if (isEmpty()) {
            first = new Node<>(elem);
            last = first;
            size ++;
            return;
        }
        Node<T> node = new Node<>(elem);
        node.next = first;
        first.prev = node;
        first = node;
        size++;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        Node<T> removed = last;
        last = last.prev;
        size--;
        return last.val;
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        Node<T> removed = first;
        first = first.next;
        size--;
        return removed.val;
    }

    public T getFirst() {
        return Optional.ofNullable(first).map(a -> a.val).orElse(null);
    }

    public T getLast() {
        return Optional.ofNullable(last).map(a -> a.val).orElse(null);
    }

    public boolean contains(T elem) {
        if(isEmpty()) return false;
        Node<T> current = first;
        while(current != null) {
            if(equals(elem, current.val)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public boolean equals(T t1, T t2) {
        return Objects.deepEquals(t1, t2);
    }

    public List<T> getAll() {
        List<T> list = new ArrayList<>(size);
        Node<T> current = first;
        while(current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("List is empty;");
            return;
        }
        Node<T> current = first;
        while(current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
    }

    public void clear() {
        first = last = null;
        size =0;
    }

}
