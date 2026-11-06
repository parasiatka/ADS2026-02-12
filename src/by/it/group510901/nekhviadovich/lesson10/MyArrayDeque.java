package by.it.group510901.nekhviadovich.lesson10;


import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayDeque<E> implements Deque<E> {

    /*toString() +
    size() +

    add(E element) +
    addFirst(E element) +
    addLast(E element) +

    element() +
    getFirst()
    getLast()

    poll()
    pollFirst()
    pollLast()*/

    private Object[] elements = new Object[10];
    private int size;

    private void tryResize(){
        if(size >= elements.length){
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public String toString(){
        if (size == 0) return "[]";
        String res = "[";
        for (int i = 0; i < size; i++){
            res += elements[i] + ", ";
        }
        res = res.substring(0, res.length()-2);
        res += "]";
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        tryResize();
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public void addFirst(E e) {
        tryResize();
        for(int i = size; i > 0; i--){
            elements[i] = elements[i-1];
        }
        elements[0] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        tryResize();
        elements[size] = e;
        size++;
    }

    @Override
    public E element() {
        if (size == 0)
            throw new NoSuchElementException();

        return (E)elements[0];
    }

    @Override
    public E getFirst() {
        if (size == 0)
            throw new NoSuchElementException();

        return (E)elements[0];
    }

    @Override
    public E getLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return (E)elements[size-1];
    }

    @Override
    public E poll() {
        if(size == 0) return null;
        E removed = (E)elements[0];
        for (int i = 0; i < size-1; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public E pollFirst() {
        if(size == 0) return null;

        E removed = (E)elements[0];
        for (int i = 0; i < size-1; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public E pollLast() {
        if(size == 0) return null;

        E removed = (E)elements[size-1];
        elements[size-1] = null;
        size--;
        return removed;
    }











    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }



    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }


    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }



    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }


    @Override
    public boolean isEmpty() {
        return false;
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
    public Iterator<E> descendingIterator() {
        return null;
    }
}
