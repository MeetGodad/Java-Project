package implementation;

import java.util.Arrays;


import utilities.Iterator;
import utilities.ListADT;


/**
 * MyDLL.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class implements a doubly linked list (DLL) and provides methods to perform various operations 
 *     such as adding, removing, and accessing elements in the list.
 */
public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == size) {
            add(toAdd);
            return true;
        }
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (index == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            } else {
                tail = newNode;
            }
            head = newNode;
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            MyDLLNode<E> nextNode = current.getNext();
            newNode.setPrev(current);
            newNode.setNext(nextNode);
            current.setNext(newNode);
            if (nextNode != null) {
                nextNode.setPrev(newNode);
            } else {
                tail = newNode;
            }
        }
        size++;
        return true;
    }

    

    @Override
    public boolean add(E element) {
        MyDLLNode<E> newNode = new MyDLLNode<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
		return false;
    }
    
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("List to add cannot be null");
        }
        int sizeBeforeAddAll = size;
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }
        return sizeBeforeAddAll != size;
    }

    
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyDLLNode<E> toRemove;
        if (index == 0) {
            toRemove = head;
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            toRemove = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            toRemove = current.getNext();
            current.setNext(toRemove.getNext());
            toRemove.getNext().setPrev(current);
        }
        size--;
        return toRemove.getData();
    }
    
    @Override
    public E remove(E element) {
        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                if (current == head) {
                    head = head.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                } else {
                    MyDLLNode<E> prevNode = current.getPrev();
                    MyDLLNode<E> nextNode = current.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                }
                size--;
                return element;
            }
            current = current.getNext();
        }
		return element;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        E oldValue = current.getData();
        current.setData(toChange);
        return oldValue;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public boolean contains(E element) {
        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Array to hold elements cannot be null");
        }
        
        if (toHold.length < size) {
            return (E[]) Arrays.copyOf(toArray(), size, toHold.getClass());
        }
        System.arraycopy(toArray(), 0, toHold, 0, size);
        if (toHold.length > size) {
            toHold[size] = null;
        }

        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyDLLNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
    
    
}