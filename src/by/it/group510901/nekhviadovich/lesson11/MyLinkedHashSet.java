package by.it.group510901.nekhviadovich.lesson11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/*
toString()
size()
clear()
isEmpty()
add(Object)
remove(Object)
contains(Object)

containsAll(Collection)
addAll(Collection)
removeAll(Collection)
retainAll(Collection)
*/

public class MyLinkedHashSet<E> implements Set<E> {
    private int size = 0;

    private Node<E> head;
    private Node<E> tail;

    private Node<E>[] table = new Node[16];

    private static class Node<E>{
        Node<E> next;
        Node<E> nextInOrder;
        Node<E> prevInOrder;
        E value;

        Node(E _val ){
            value = _val;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        String res = "[";
        boolean first = true;


        Node<E> curr = head;
        while (curr != null) {
            if (!first) res += ", ";
            res += curr.value;
            first = false;
            curr = curr.nextInOrder;
        }

        res += "]";
        return res;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++ ){
            table[i] = null;
        }
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean add(E e) {
        int hash;
        if(e == null)
            hash = 0;
        else
            hash = Math.abs(e.hashCode() % table.length);


        Node curr = table[hash];
        while (curr != null){
            if (e == null ? curr.value == null : e.equals(curr.value))
                return false;
            curr = curr.next;
        }


        Node added = new Node(e);
        added.next = table[hash];
        table[hash] = added;


        if(head == null){
            head = added;
        }
        else{
            tail.nextInOrder = added;
            added.prevInOrder = tail;
        }
        tail = added;


        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int hash;
        if(o == null)
            hash = 0;
        else
            hash = Math.abs(o.hashCode() % table.length);

        Node curr = table[hash];
        Node prev = null;
        while (curr != null){
            if (o == null ? curr.value == null : o.equals(curr.value)){
                if(prev == null)
                    table[hash] = curr.next;
                else
                    prev.next = curr.next;


                if(curr.prevInOrder == null) // еслт голова
                    head = curr.nextInOrder;
                else
                    curr.prevInOrder.nextInOrder = curr.nextInOrder;


                if(curr.nextInOrder == null) //если хвост
                    tail = curr.prevInOrder;
                else
                    curr.nextInOrder.prevInOrder = curr.prevInOrder;

                size--;
                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }


    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        int hash;
        if(o == null)
            hash = 0;
        else
            hash = Math.abs(o.hashCode() % table.length);


        Node curr = table[hash];

        while (curr != null){
            if (o == null ? curr.value == null : o.equals(curr.value))
                return true;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(c == null) throw new NullPointerException();

        for (Object o : c){
            if( ! contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c == null) throw new NullPointerException();

        boolean wasChanged = false;
        for (E el : c){
            if(add(el)) wasChanged = true;
        }
        return wasChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null) throw new NullPointerException();

        boolean wasChanged = false;

        Node curr = head;
        Node next;
        while (curr != null){
            next = curr.nextInOrder;
            if(!c.contains(curr.value)){
                remove(curr.value);
                wasChanged = true;
            }
            curr = next;
        }
        return wasChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(c == null) throw new NullPointerException();

        boolean wasChanged = false;
        for (Object o : c){
            if(remove(o)) wasChanged = true;
        }
        return wasChanged;
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
