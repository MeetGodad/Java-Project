package implementation;

import Exception.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * MyQueue.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: MyQueue is an implementation of a generic queue data structure. It utilizes a doubly linked list (MyDLL)
 *     to store the elements. The class provides methods to enqueue, dequeue, peek, and perform other operations on the queue, adhering to the QueueADT interface.
 */
public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> elements;

    public MyQueue() {
        elements = new MyDLL<>();
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        elements.add(toAdd);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return elements.remove(0);
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return elements.get(0);
    }

    @Override
    public void dequeueAll() {
        elements.clear();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        if (this == that) return true;
        if (that == null) return false;
        if (size() != that.size()) return false;

        Iterator<E> thisIterator = iterator();
        Iterator<E> thatIterator = that.iterator();

        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();
            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }

        return !thisIterator.hasNext() && !thatIterator.hasNext();
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return elements.toArray(holder);
    }

    

    @Override
    public int size() {
        return elements.size();
    }

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
}
