package by.it.group510901.nekhviadovich.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListC<E> implements List<E> {

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////


    private Object[] elements = new Object[10];
    private int size = 0; // колво элементов

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
    public String toString() {
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
    public boolean add(E e) {

        tryResize();
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E removed = (E)elements[index];
        for (int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        elements[size-1] = null;
        size--;
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw  new IndexOutOfBoundsException();
        }
        tryResize();
        for (int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < size; i++){
            if(o == null ? elements[i] == null : o.equals(elements[i])){
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E removed = (E)elements[index];
        elements[index] = element;
        return removed;
    }


    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(o == null ? elements[i] == null : o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw  new IndexOutOfBoundsException();
        }
        return (E)elements[index];
    }

    @Override
    public boolean contains(Object o) {
        if(this.indexOf(o) == -1 ) return false;
        return true;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size-1; i >= 0; i--){
            if(o == null ? elements[i] == null : o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if(c == null) throw new NullPointerException();
        if(c.size() == 0) return true;
        for(var element : c){
            if( ! this.contains(element)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c == null) throw new NullPointerException();
        if(c.size() == 0) return false;
        for(var element : c){
            this.add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(index < 0 || index > size) throw  new IndexOutOfBoundsException();
        if(c == null) throw new NullPointerException();
        if(c.size() == 0) return false;
        for(var element : c){
            this.add(index, element);
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(c == null) throw new NullPointerException();
        if(c.size() == 0) return false;

        boolean hasRemoved = false;
        for(int i = 0; i < size; i++){
            if(c.contains(elements[i])){
                this.remove(i);
                hasRemoved = true;
                i--; // чтоб не скипнуть след.элемент при удалении
            }
        }
        return hasRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null) throw new NullPointerException();

        boolean hasRemoved = false;
        for(int i = 0; i < size; i++){
            if(! c.contains(elements[i])){
                this.remove(i);
                hasRemoved = true;
                i--;
            }
        }
        return hasRemoved;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
