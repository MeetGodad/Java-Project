package treeImplementation;

import utilities.BSTreeADT;
import utilities.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
/**
 * BSTree.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.1 Class Description: This class implements a Binary Search Tree (BST) data structure. It provides methods for managing and manipulating a BST,
 *  such as adding, removing, searching for elements, getting the root, determining the size and height, and creating iterators for traversing the tree 
 *  in different orders (inorder, preorder, and postorder).
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;
    
    public BSTree() {
        this.root = null;
    }

    @Override
    public BSTreeNode<E> getRoot() throws NullPointerException {
        if (isEmpty())
            throw new NullPointerException("Tree is empty");
        return root;
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BSTreeNode<E> node) {
        if (node == null)
            return -1;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTreeNode<E> node) {
        if (node == null)
            return 0;
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(E entry) throws NullPointerException {
        if (entry == null)
            throw new NullPointerException("Entry cannot be null");
        return search(entry) != null;
    }

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        if (entry == null)
            throw new NullPointerException("Entry cannot be null");
        return search(root, entry);
    }

    private BSTreeNode<E> search(BSTreeNode<E> node, E entry) {
        if (node == null || node.getElement().equals(entry))
            return node;
        if (entry.compareTo(node.getElement()) < 0)
            return search(node.getLeft(), entry);
        else
            return search(node.getRight(), entry);
    }

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null)
            throw new NullPointerException("Entry cannot be null");
        if (root == null) {
            root = new BSTreeNode<>(newEntry);
            return true;
        } else {
            return add(root, newEntry);
        }
    }

    private boolean add(BSTreeNode<E> node, E newEntry) {
        if (newEntry.equals(node.getElement()))
            return false; // Duplicate elements are not allowed
        else if (newEntry.compareTo(node.getElement()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTreeNode<>(newEntry));
                return true;
            } else {
                return add(node.getLeft(), newEntry);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BSTreeNode<>(newEntry));
                return true;
            } else {
                return add(node.getRight(), newEntry);
            }
        }
    }

    @Override
    public BSTreeNode<E> removeMin() {
        if (isEmpty())
            return null;
        else {
            BSTreeNode<E> minNode = findMin(root);
            root = removeMin(root);
            return minNode;
        }
    }

    private BSTreeNode<E> findMin(BSTreeNode<E> node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    private BSTreeNode<E> removeMin(BSTreeNode<E> node) {
        if (node.getLeft() == null)
            return node.getRight();
        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

    @Override
    public BSTreeNode<E> removeMax() {
        if (isEmpty())
            return null;
        else {
            BSTreeNode<E> maxNode = findMax(root);
            root = removeMax(root);
            return maxNode;
        }
    }

    private BSTreeNode<E> findMax(BSTreeNode<E> node) {
        while (node.getRight() != null)
            node = node.getRight();
        return node;
    }

    private BSTreeNode<E> removeMax(BSTreeNode<E> node) {
        if (node.getRight() == null)
            return node.getLeft();
        node.setRight(removeMax(node.getRight()));
        return node;
    }

    @Override
    public Iterator<E> inorderIterator() {
        return new InorderIterator();
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack;

        public InorderIterator() {
            stack = new Stack<>();
            populateStack(root);
        }

        private void populateStack(BSTreeNode<E> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext())
                throw new NoSuchElementException("No more elements in the iterator");
            BSTreeNode<E> current = stack.pop();
            populateStack(current.getRight());
            return current.getElement();
        }
    }

    private class PreorderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack;

        public PreorderIterator() {
            stack = new Stack<>();
            if (root != null)
                stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext())
                throw new NoSuchElementException("No more elements in the iterator");
            BSTreeNode<E> current = stack.pop();
            if (current.getRight() != null)
                stack.push(current.getRight());
            if (current.getLeft() != null)
                stack.push(current.getLeft());
            return current.getElement();
        }
    }

    private class PostorderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack;

        public PostorderIterator() {
            stack = new Stack<>();
            populateStack(root);
        }

        private void populateStack(BSTreeNode<E> node) {
            if (node == null)
                return;
            
            Stack<BSTreeNode<E>> tempStack = new Stack<>();
            tempStack.push(node);

            while (!tempStack.isEmpty()) {
                BSTreeNode<E> current = tempStack.pop();
                stack.push(current);

                if (current.getLeft() != null)
                    tempStack.push(current.getLeft());
                if (current.getRight() != null)
                    tempStack.push(current.getRight());
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext())
                throw new NoSuchElementException("No more elements in the iterator");
            return stack.pop().getElement();
        }
    }

    
}
  