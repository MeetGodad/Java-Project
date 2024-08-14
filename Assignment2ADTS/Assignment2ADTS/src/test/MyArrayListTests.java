package test;

import static org.junit.Assert.*;

import org.junit.*;

import utilities.Iterator;
import utilities.ListADT;
import implementation.MyArrayList;

/**
 * MyArrayListTests.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.2
 */
public class MyArrayListTests<E> {
    private ListADT<E> list;

    @Before
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        list.add((E) "Object1");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddAtIndex() {
        list.add(0, (E) "Object");
        assertEquals(1, list.size());
    }
    
    @Test
    public void testAdd() {
        list.add((E) "1");
        assertEquals(1, list.size());
    }

    @Test
    public void testAddAll() {
        MyArrayList<E> otherList = new MyArrayList<>();
        otherList.add((E) "Object");
        otherList.add((E) "2");
        list.addAll(otherList);
        assertEquals(2, list.size());
        assertTrue(list.contains((E) "Object"));
        assertTrue(list.contains((E) "2"));
    }

    @Test
    public void testGet() {
        list.add((E) "Object1");
        assertEquals("Object1", list.get(0));
    }

    @Test
    public void testRemoveIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }
    
    @Test
    public void testRemove() {
        list.add(0, (E) "1");
        list.remove((E) "1");
        assertEquals(0, list.size());
    }


    @Test
    public void testSet() {
        list.add((E) "OldObject");
        assertEquals("OldObject", list.set(0, (E) "NewObject"));
    }

    
    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        list.add(0, (E) "Object");
        assertTrue(list.contains((E) "Object"));
    }

    @Test
    public void testToArray() {
        list.add((E) "Object1");
        list.add((E) "Object2");
        Object[] array = list.toArray();
        assertNotNull(array);
        assertArrayEquals(new Object[]{"Object1", "Object2"}, array);
    }
    @Test
    public void testToArrayHold() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] array1 = new Integer[list.size()];
        Integer[] expected1 = {1, 2, 3};
        assertArrayEquals(expected1, list.toArray(array1));
    }
    @Test
    public void testIterator() {
        list.add((E) "Object1");
        list.add((E) "Object2");
        list.add((E) "3");

        Iterator<E> iterator = list.iterator();

        assertNotNull(iterator);

        assertTrue(iterator.hasNext());
        assertEquals("Object1", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Object2", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("3", iterator.next());

        assertFalse(iterator.hasNext());
    }
}
