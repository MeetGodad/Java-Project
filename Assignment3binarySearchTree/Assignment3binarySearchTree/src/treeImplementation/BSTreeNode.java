package treeImplementation;

import java.io.Serializable;
/**
 * BSTreeNode.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class represents a node in a Binary Search Tree (BST). Each node contains an element of generic type E, as well as 
 * references to its left and right children nodes.
 */
public class BSTreeNode<E> implements Serializable {
    
    private static final long serialVersionUID = -2472546079381363389L;
    
    private E element;
    private BSTreeNode<E> left;
    private BSTreeNode<E> right;

    public BSTreeNode(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BSTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    public BSTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }
    
}
