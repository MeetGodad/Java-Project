package test;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import implementation.MyDLL;
import utilities.ListADT;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * MyDLLTests.java
 *
 * @author Nishit Patel, Meet Patel, Shubham Patil, Yash Hingu
 * @version 1.2
 */
public class MyDLLTests {
    private ListADT<String> list;

    @Before
    public void setUp() {
        list = new MyDLL<>();
    }

    @Test
    public void testSizeWhenEmpty() {
        assertEquals(0, list.size());
    }
    
    @Test
    public void testClear() {
        list.add("Object");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("Object"));
    }
    
    @Test
    public void testAdd() {
        list.add("Object");
        assertEquals(1, list.size());
        assertTrue(list.contains("Object"));
    }

    @Test
    public void testRemove() {
        list.add("Object");
        list.remove("Object");
        assertEquals(0, list.size());
        assertFalse(list.contains("Object"));
    }

    @Test
    public void testGet() {
        list.add("Object1");
        list.add("Object2");
        list.add("Object3");
        assertEquals("Object2", list.get(1));
    }

    

    @Test
    public void testContains() {
        list.add("Object");
        assertTrue(list.contains("Object"));
        assertFalse(list.contains("NonExistingObject"));
    }

    @Test
    public void testAddAtIndex() {
        list.add("Object1");
        list.add("Object3");
        list.add(1, "Object2");
        assertEquals(3, list.size());
        assertEquals("Object2", list.get(1));
    }


    @Test
    public void testRemoveAtIndex() {
        list.add("Object1");
        list.add("Object2");
        list.add("Object3");
        list.remove(1);
        assertEquals(2, list.size());
        assertFalse(list.contains("Object2"));
    }


    @Test
    public void testSet() {
        list.add("Object1");
        list.add("Object2");
        list.add("Object3");
        assertEquals("Object2", list.set(1, "NewObject"));
        assertEquals("NewObject", list.get(1));
    }


    @Test
    public void testAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("1");
        toAdd.add("2");
        list.add("Object");
        list.addAll(toAdd);
        assertEquals(3, list.size());
        assertTrue(list.contains("1"));
        assertTrue(list.contains("2"));
    }


    @Test
    public void testToArray() {
        list.add("Object1");
        list.add("Object2");
        Object[] array = list.toArray();
        assertNotNull(array);
        assertEquals(2, array.length);
        assertEquals("Object1", array[0]);
        assertEquals("Object2", array[1]);
    }



    @Test
    public void testIterator() {
        list.add("Object1");
        list.add("Object2");
        utilities.Iterator<String> iterator = list.iterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals("Object1", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Object2", iterator.next());
        assertFalse(iterator.hasNext());
    }


}

