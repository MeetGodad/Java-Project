package implementation;


/**
 * MyDLLNode.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: MyDLLNode is a generic class designed to facilitate the implementation of a doubly linked list. 
 * It contains methods for accessing and modifying the data stored in the node, as well as references to the previous and next nodes in the list.
 */
public class MyDLLNode<E> {
    private E data;
    private MyDLLNode<E> prev;
    private MyDLLNode<E> next;

    public MyDLLNode(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public MyDLLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
}
