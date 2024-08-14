package BSTreeTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import treeImplementation.BSTree;
import treeImplementation.BSTreeNode;
import utilities.Iterator;

import java.util.NoSuchElementException;
/**
 * BSTreeTest.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.2
 */
public class BSTreeTest {

    private BSTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BSTree<>();
        
    }

    @Test
    public void testIsEmpty() {
        tree.clear();
        assertTrue(tree.isEmpty());
    }
    @Test
    public void testGetRoot() {
    	tree.add(5);
        tree.add(3);
        tree.add(7);
        BSTreeNode<Integer> root = tree.getRoot();
        assertEquals(5, (int) root.getElement());
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetRootWhenEmpty() {
    	tree = new BSTree<>();
        tree.getRoot(); 
    }
    
    @Test
    public void testGetHeightWhenEmpty() {
        assertEquals(-1, tree.getHeight());
    }

    @Test
    public void testGetHeightWithSingleNode() {
        tree.add(5);
        assertEquals(0, tree.getHeight());
    }

    @Test
    public void testGetHeightWithMultipleNodes() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        assertEquals(1, tree.getHeight());
    }

    @Test
    public void testGetHeightWithNodesOnOneSide() {
        tree.add(5);
        tree.add(4);
        tree.add(3);
        assertEquals(2, tree.getHeight());
    }

    @Test
    public void testGetHeightUnbalanced() {
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        assertEquals(3, tree.getHeight());
    }

    @Test
    public void testGetHeightBalanced() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        assertEquals(2, tree.getHeight());
    }
    
    @Test
    public void testSizeWhenEmpty() {
        assertEquals(0, tree.size());
    }

    @Test
    public void testSizeWithSingleNode() {
        tree.add(5);
        assertEquals(1, tree.size());
    }

    @Test
    public void testSizeWithMultipleNodes() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        assertEquals(3, tree.size());
    }

    @Test
    public void testSizeWithNodesOnOneSide() {
        tree.add(5);
        tree.add(4);
        tree.add(3);
        assertEquals(3, tree.size());
    }

    @Test
    public void testSizeUnbalanced() {
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        assertEquals(4, tree.size());
    }

    @Test
    public void testSizeBalanced() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        assertEquals(7, tree.size());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        tree.add(5);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testClear() {
        // Add some elements to the tree
        tree.add(5);
        tree.add(3);
        tree.add(7);

   
        tree.clear();

        assertTrue(tree.isEmpty());
    }
    
    @Test
    public void testContainsWhenEmpty() {
        assertFalse(tree.contains(5));
    }

    @Test
    public void testContainsWhenEntryExists() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        assertTrue(tree.contains(5));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
    }

    @Test
    public void testContainsWhenEntryDoesNotExist() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        assertFalse(tree.contains(10));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNullEntry() {
        tree.contains(null); // This should throw a NullPointerException
    }
    
    @Test
    public void testSearchWhenEmpty() {
        assertNull(tree.search(5));
    }

    @Test
    public void testSearchWhenEntryExists() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        assertEquals(5, (int) tree.search(5).getElement());
        assertEquals(3, (int) tree.search(3).getElement());
        assertEquals(7, (int) tree.search(7).getElement());
    }
    
    @Test
    public void testSearchWhenEntryDoesNotExist() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        assertNull(tree.search(10));
    }

    @Test(expected = NullPointerException.class)
    public void testSearchNullEntry() {
        tree.search(null); // This should throw a NullPointerException
    }
    
    
    @Test
    public void testAddToEmptyTree() {
        assertTrue(tree.add(5));
        assertEquals(5, (int) tree.getRoot().getElement());
    }

    @Test
    public void testAddSmallerThanRoot() {
        tree.add(5);
        assertTrue(tree.add(3));
        assertEquals(3, (int) tree.getRoot().getLeft().getElement());
    }

    @Test
    public void testAddGreaterThanRoot() {
        tree.add(5);
        assertTrue(tree.add(7));
        assertEquals(7, (int) tree.getRoot().getRight().getElement());
    }

    @Test
    public void testAddDuplicateEntry() {
        tree.add(5);
        assertFalse(tree.add(5));
        assertEquals(1, tree.size()); // Size should remain unchanged
    }

    @Test
    public void testAddMultipleEntries() {
        assertTrue(tree.add(5));
        assertTrue(tree.add(3));
        assertTrue(tree.add(7));
        assertTrue(tree.add(2));
        assertTrue(tree.add(4));
        assertTrue(tree.add(6));
        assertTrue(tree.add(8));

        assertEquals(5, (int) tree.getRoot().getElement());
        assertEquals(3, (int) tree.getRoot().getLeft().getElement());
        assertEquals(7, (int) tree.getRoot().getRight().getElement());
        assertEquals(2, (int) tree.getRoot().getLeft().getLeft().getElement());
        assertEquals(4, (int) tree.getRoot().getLeft().getRight().getElement());
        assertEquals(6, (int) tree.getRoot().getRight().getLeft().getElement());
        assertEquals(8, (int) tree.getRoot().getRight().getRight().getElement());
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddNullEntry() {
        tree.add(null);
    }

    @Test
    public void testRemoveMinFromNonEmptyTree() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        
        assertEquals(3, (int) tree.removeMin().getElement());
        assertEquals(2, tree.size()); // Size should decrease by 1
    }

    @Test
    public void testRemoveMinFromEmptyTree() {
        assertNull(tree.removeMin());
        assertEquals(0, tree.size()); // Size should remain 0
    }
    
    @Test
    public void testRemoveMaxFromNonEmptyTree() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

       
        assertEquals(7, (int) tree.removeMax().getElement());
        assertEquals(2, tree.size()); // Size should decrease by 1
    }

    @Test
    public void testRemoveMaxFromEmptyTree() {
        assertNull(tree.removeMax());
        assertEquals(0, tree.size()); // Size should remain 0
    }
    
    @Test
    public void testInorderIteratorNonEmptyTree() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.inorderIterator();

        assertEquals(3, (int) iterator.next());
        assertEquals(5, (int) iterator.next());
        assertEquals(7, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testInorderIteratorEmptyTree() {
        Iterator<Integer> iterator = tree.inorderIterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testPreorderIteratorNonEmptyTree() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.preorderIterator();

        assertEquals(5, (int) iterator.next());
        assertEquals(3, (int) iterator.next());
        assertEquals(7, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPreorderIteratorEmptyTree() {
        Iterator<Integer> iterator = tree.preorderIterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testPostorderIteratorNonEmptyTree() {
        tree.add(5);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.postorderIterator();

        assertEquals(3, (int) iterator.next());
        assertEquals(7, (int) iterator.next());
        assertEquals(5, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPostorderIteratorEmptyTree() {
        Iterator<Integer> iterator = tree.postorderIterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

}
