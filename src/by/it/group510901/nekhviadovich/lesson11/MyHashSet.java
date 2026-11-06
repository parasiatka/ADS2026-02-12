package by.it.group510901.nekhviadovich.lesson11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;



/*
size()
clear()
isEmpty()
add(Object)
remove(Object)
contains(Object)
*/

public class MyHashSet<E> implements Set<E> {

    private int size = 0;
    private Node<E>[] table = new Node[16];

    private static class Node<E>{
        Node<E> next;
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

        for (int i = 0; i < table.length; i++) {
            Node<E> curr = table[i];
            while (curr != null) {
                if (!first) res += ", ";
                res += curr.value;
                first = false;
                curr = curr.next;
            }
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }


}
