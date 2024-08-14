package implementation;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;

/**
 * MyStack.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class implements the StackADT interface. It utilizes MyArrayList to store the elements.
 * 
 */
public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> elements;

    public MyStack() {
        elements = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot push null element");
        }
        elements.add(toAdd);
    }
    
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = elements.get(size() - 1 - i);
        }
        return array;
    }
    
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Provided array cannot be null");
        }
        
        for (int i = 0; i < size(); i++) {
            holder[size() - 1 - i] = elements.get(i);
        }
        return holder;
    }
    
    @Override
	public boolean contains(E toFind) throws NullPointerException {
		return elements.contains(toFind);
	}
	   
    @Override
    public int search(E toFind) {
		for (int i = elements.size() - 1; i >= 0; i--) {
			if (toFind.equals(elements.get(i))) {
				return elements.size() - i;
			}
		}
		return -1;
		}
  
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = size() - 1; // Start from the top of the stack

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements.get(currentIndex--); // Return current element and move to the next one
            }
        };
    }


	 @Override
	 public boolean equals(StackADT<E> that) {
	      if (this == that) return true;
	      if (that == null || this.size() != that.size()) return false;
	
	      Iterator<E> thisIterator = this.iterator();
	      Iterator<E> thatIterator = that.iterator();
	
	      while (thisIterator.hasNext()) {
	          if (!thisIterator.next().equals(thatIterator.next())) {
	              return false;
	          }
	      }
	
	      return true;
	  }
  
	 @Override
	 public int size() {
	        return elements.size();
	    }
		
	 @Override
	 public boolean isFull() {
		 return elements.size() == MyArrayList.DEFAULT_CAPACITY;
		}


}
