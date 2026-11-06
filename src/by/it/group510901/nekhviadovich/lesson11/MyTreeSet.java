package by.it.group510901.nekhviadovich.lesson11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTreeSet<E extends Comparable<E>> implements Set<E> {

    private E[] elements = (E[]) new Comparable[10];
    int size = 0;

    private void tryResize() {
        if (size >= elements.length) {
            Comparable[] newElements = new Comparable[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = (E[]) newElements;
        }
    }

    private int binarySearch(E e){
        int left = 0;
        int right = size-1;
        int mid = 0;


        while(left <= right){
            mid = (left + right) / 2;

            int cmp = e.compareTo((E)elements[mid]);

            if(cmp == 0 ){
                return mid;
            } else if (cmp < 0) {
                right = mid-1;
            }
            else {
                left = mid +1;
            }
        }
        return -(left) -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        int index = binarySearch(e);

        if (index >= 0) return false; //уже есть

        int insertPos = -index - 1;
        tryResize();

        for (int i = size; i > insertPos; i--) {
            elements[i] = elements[i - 1];
        }
        elements[insertPos] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) throw new NullPointerException();

        int index;
        index = binarySearch((E) o);


        if (index < 0) return false; // нет такого

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException();

        return binarySearch((E) o) >= 0;

    }



    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) throw new NullPointerException();
        boolean changed = false;
        for (E el : c) {
            if (add(el)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        boolean changed = false;
        for (Object o : c) {
            if (remove(o)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        boolean changed = false;

        E[] kept = (E[]) new Comparable[elements.length];
        int newSize = 0;

        for (int i = 0; i < size; i++) {
            if (c.contains(elements[i])) {
                kept[newSize++] = elements[i];
            } else {
                changed = true;
            }
        }

        elements = kept;
        size = newSize;
        return changed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        String res = "[";
        for (int i = 0; i < size; i++) {
            res += elements[i];
            if (i < size - 1) res += ", ";
        }
        res += "]";
        return res;
    }














    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



}










