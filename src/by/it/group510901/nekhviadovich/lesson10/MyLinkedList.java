package by.it.group510901.nekhviadovich.lesson10;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Deque<E> {

    /*
    toString() +
    add(E element) +
    remove(int) +
    remove(E element) +
    size() +

    addFirst(E element) +
    addLast(E element) +

    element() +
    getFirst() +
    getLast() +

    poll() +
    pollFirst() +
    pollLast() +
    */

    private Node<E> head;
    private Node<E> tail;
    private int size;

    static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;
    }

    @Override
    public String toString(){
        if (size == 0) return "[]";
        String res = "[";
        Node curr = head;
        for (int i = 0; i < size; i++){
            res += curr.value + ", ";
            curr = curr.next;
        }
        res = res.substring(0, res.length()-2);
        res += "]";
        return res;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>();
        newNode.value = e;

        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;

        return true;
    }


    private E unlink(Node curr){
        if(curr.prev == null){
            head = curr.next;
        }
        else{
            curr.prev.next = curr.next;
        }

        if(curr.next == null) {
            tail = curr.prev;
        }
        else {
            curr.next.prev = curr.prev;
        }
        size--;
        return (E)curr.value;
    }


    @Override
    public E remove() {
        if(size == 0) throw new NoSuchElementException();
        return unlink(head);
    }



    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        E temp = curr.value;

        unlink(curr);

        return temp;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> curr = head;

        boolean isEqual;

        while(curr != null){


            if (o == null) {
                isEqual = (curr.value == null);
            } else {
                isEqual = o.equals(curr.value);
            }

            if (isEqual) {
                unlink(curr);
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>();
        newNode.value = e;
        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        add(e);
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public E getLast() {
        if (size == 0) throw new NoSuchElementException();
        return tail.value;
    }


    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E pollFirst() {
        if(size == 0)return null;
        return unlink(head);
    }

    @Override
    public E pollLast() {
        if(size == 0)return null;
        E temp = tail.value;
        tail = tail.prev;
        if(tail == null) head = null;
        else{
            tail.next = null;
        }

        size--;
        return temp;
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
