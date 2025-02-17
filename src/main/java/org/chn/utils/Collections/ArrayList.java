package org.chn.utils.Collections;

import java.util.Collection;
import java.util.HashSet;

public class ArrayList<T> {

    /**
     * [0,1,0,0,0,0,0,0,0,0]
     * |                 |
     * add (1)
     * [0,0,0,0,0,0,0,0,0,0]
     * |               |
     */

    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    //    private int size;
    private int currentIndex;


    public ArrayList() {
        this.array = new Object[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        this.array = new Object[size];
    }

    public int size() {
        return currentIndex;
    }

    public void add(T element) {
        if (currentIndex >= array.length - 1) {
            reSizeArrayMore();
        }
        array[currentIndex++] = element;
    }

    private void reSizeArrayMore() {
        Object[] newArr = new Object[array.length + array.length / 2];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public T get(int index) {
        if (index >= size() || index < 0) throw new ArrayIndexOutOfBoundsException("Array length is : " + size());
        return (T) array[index];
    }

    public void removeAt(int index) {
        if (index >= size() || index < 0) throw new ArrayIndexOutOfBoundsException("Array length is : " + size());
        if (index == size() - 1) {
            currentIndex--;
            return;
        }
        boolean removed = false;
        int j = index;
        for (int i = index; i < size(); i++) {
            if (i == index) {
                continue;
            }
            array[j++] = array[i];
        }
        currentIndex = j;
    }

    public int getIndexOf(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if (obj == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public void remove(Object element) {
        int ind = getIndexOf(element);
        if (ind == -1) throw new UnsupportedOperationException("Object not found!");
        removeAt(ind);
    }

    public void removeAllOccurances(Object element) {
        int firstIndex = getIndexOf(element);
        if (firstIndex == size() - 1) {
            removeAt(firstIndex);
            return;
        }
        int j = firstIndex;
        for (int i = firstIndex; i < size(); i++) {
            if (array[i] == element) {
                continue;
            }
            array[j++] = array[i];
        }
        currentIndex = j;
    }

    public void addAll(Collection<T> collection) {
        for (T t :
                collection) {
            add(t);
        }

    }

    public void removeAll(Collection<T> collection) {
        HashSet<T> hashSet = new HashSet<>();
        for (T t :
                collection) {
            hashSet.add(t);
        }
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(hashSet.contains(array[i])) {
                continue;
            }
            array[j++] = array[i];
        }
    }

    public Object[] toArray() {
        Object[] ar = new Object[size()];
        for (int i = 0; i < size(); i++) {
            ar[i] = array[i];
        }
        return ar;
    }


}
