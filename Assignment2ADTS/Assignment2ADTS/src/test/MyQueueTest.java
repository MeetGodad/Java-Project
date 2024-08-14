package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Exception.EmptyQueueException;
import implementation.MyQueue;
import utilities.Iterator;

/**
 * MyQueueTest.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.2
 */
public class MyQueueTest {

    private MyQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() throws EmptyQueueException {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void testDequeue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue().intValue());
        assertEquals(2, queue.dequeue().intValue());
    }

    @Test
    public void testPeek() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek().intValue());
        assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void testDequeueAll() {
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
       
        queue.dequeueAll();
        
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }


    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
    @Test
    public void testIterator() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Iterator<Integer> iterator = queue.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }
    @Test
    public void testEquals() {
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        assertTrue(queue1.equals(queue2)); 
    }
    

    @Test
    public void testToArray() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Object[] array = queue.toArray();
        assertArrayEquals(new Object[]{1, 2, 3}, array);
    }

    @Test
    public void testToArrayWithHolder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Integer[] array = new Integer[3];
        Integer[] result = queue.toArray(array);
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
        assertSame(array, result);
    }
    
    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }
}
