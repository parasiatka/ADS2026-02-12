package by.it.group510901.nekhviadovich.lesson10;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyPriorityQueue<E extends Comparable<E>> implements Queue<E> {

   /* toString() +
    size() +
    clear()
    add(E element)
    remove()
    contains(E element)

    offer(E element)
    poll()
    peek()
    element()
    isEmpty()

    containsAll(Collection<E> c)
    addAll(Collection<E> c)
    removeAll(Collection<E> c)
    retainAll(Collection<E> c) */



    /*
    a.compareTo(b) < 0	a меньше b
    a.compareTo(b) > 0	a больше b
    a.compareTo(b) == 0	a равно b
    */


    private E[] elements = (E[]) new Comparable[10];
    private int size = 0;



    private void tryResize(){
        if(size >= elements.length){
            Comparable[] newElements = new Comparable[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = (E[])newElements;
        }
    }

    private void siftUp(int index){

        while(index > 0){
            int parent = (index-1)/2;

            if(elements[parent].compareTo(elements[index])>0){
                E temp = elements[parent];
                elements[parent] = elements[index];
                elements[index] = temp;

                index = parent;
            }
            else {break;}
        }
    }

    private void siftDown(int index) {
        while (true) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;

            int smallest = index;

            if (leftChild < size && elements[leftChild].compareTo(elements[smallest]) < 0) {
                smallest = leftChild;
            }

            if (rightChild < size && elements[rightChild].compareTo(elements[smallest]) < 0) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            E temp = elements[index];
            elements[index] = elements[smallest];
            elements[smallest] = temp;

            index = smallest;
        }
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
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        tryResize();
        elements[size] = e;
        size++;
        siftUp(size - 1);

        return true;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        if (size == 0) throw new NoSuchElementException();

        E result = elements[0];
        elements[0] = elements[size - 1];
        elements[size - 1] = null;
        size--;

        if (size > 0) {
            siftDown(0);
        }
        return result;
    }

    @Override
    public E poll() {
        if (size == 0) return null;
        return remove();
    }

    @Override
    public E element() {
        if (size == 0) throw new NoSuchElementException();
        return elements[0];
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        return elements[0];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null ? elements[i] == null : o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        for (Object el : c) {
            if (!contains(el)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) throw new NullPointerException();
        boolean changed = false;
        for (E el : c) {
            add(el);
            changed = true;
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        E[] kept = (E[]) new Comparable[elements.length]; // временный массив

        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                kept[newSize++] = elements[i];
            }
        }
        boolean changed = newSize != size;
        elements = kept;
        size = newSize;

        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        E[] kept = (E[]) new Comparable[elements.length];
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (c.contains(elements[i])) { // если есть в с остав
                kept[newSize++] = elements[i];
            }
        }
        boolean changed = newSize != size;
        elements = kept;
        size = newSize;
        // Перестраиваем кучу (heapify)
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
        return changed;
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



    @Override
    public boolean remove(Object o) {
        return false;
    }









}
