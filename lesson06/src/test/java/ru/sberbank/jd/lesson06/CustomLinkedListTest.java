package ru.sberbank.jd.lesson06;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class CustomLinkedListTest {

    CustomLinkedList<Integer> list;
    @Before
    public void setup() {
        list = new CustomLinkedList<>();
    }

    @Test
    public void test1() {

        assertEquals(0, list.size());
    }

    @Test
    public void test2() {
        assertTrue(list.add(1));
        assertEquals(1, list.size());
    }

    @Test
    public void test3() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertEquals(2, list.size());
    }

    @Test
    public void test4() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertTrue(list.add(4));
        assertTrue(list.add(5));
        assertEquals(5, list.size());
    }

    @Test
    public void test5() {
        assertTrue(list.isEmpty());
        assertTrue(list.add(null));
        assertFalse(list.isEmpty());
    }

    @Test
    public void test6() {
        assertTrue(list.addAll(new Integer[]{1, 2, 3}));
        assertEquals(3, list.size());
    }

//    @Test(expected = RuntimeException.class)
    @Test
    public void test7() {
        Integer [] array = null;
        assertFalse(list.addAll(array));
    }

    @Test
    public void test8() {
        List<Integer> integers = List.of(1, 2, 3);
        assertTrue(list.addAll(integers));
    }

    //    @Test(expected = RuntimeException.class)
    @Test
    public void test9() {
        List<Integer> integers = null;
        assertFalse(list.addAll(integers));
    }

    @Test
    public void test10() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        list.remove(1);
        assertEquals(2, list.size());
    }
}