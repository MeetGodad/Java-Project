package test;
import static org.junit.Assert.*;
import utilities.Iterator;
import utilities.StackADT;

import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;
import implementation.MyStack;

/**
 * MyStackTest.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.2
 */
public class MyStackTest {

    private MyStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek().intValue());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
        assertTrue(stack.isEmpty());
    }

    
    @Test
    public void testPeek() {
        stack.push(1);
        assertEquals(1, stack.peek().intValue());
        assertEquals(1, stack.peek().intValue());
    }


    @Test
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testToArray() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Object[] array = stack.toArray();
        assertArrayEquals(new Object[]{3, 2, 1}, array);
    }
    
    @Test
    public void testToArrayWithHolder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer[] array = new Integer[3];
        Integer[] result = stack.toArray(array);
        assertArrayEquals(new Integer[]{3, 2, 1}, array);
        assertSame(array, result);
    }
    

    @Test
    public void testContains() {
        stack.push(1);
        stack.push(2);
        assertTrue(stack.contains(1));
        assertFalse(stack.contains(3));
    }

    @Test
    public void testSearch() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.search(3));
        assertEquals(2, stack.search(2));
        assertEquals(-1, stack.search(4));
    }

    @Test
    public void testEquals() {
        MyStack<Integer> stack1 = new MyStack<>();
        MyStack<Integer> stack2 = new MyStack<>();
        
        stack1.push(1);
        stack1.push(2);
        stack2.push(1);
        stack2.push(2);
        
        assertTrue(stack2.equals(stack1));
    }
    
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }
    @Test
    public void testIterator() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Iterator<Integer> iterator = stack.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }
  
    @Test
    public void testIsFull() {
        MyStack<Integer> stack = new MyStack<>();
        assertFalse(stack.isFull()); // Initially, the stack should not be full
        stack.push(1);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(2);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(3);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(4);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(5);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(6);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(7);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(8);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(9);
        assertFalse(stack.isFull()); // After adding one element, it should still not be full
        stack.push(10);
        assertTrue(stack.isFull()); // After adding the second element, it should be full
    }


}
