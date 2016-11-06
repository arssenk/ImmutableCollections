package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {
    @Test
    public void add() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList();
        ImmutableList test__2 = test_1.add(4);
        Integer[] expected = {4};
        assertArrayEquals(expected, test__2.toArray());
    }

    @Test
    public void add1() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {5,4,3,2,1});
        ImmutableList test__2 = test_1.add(0, 999);
        Integer[] expected = {999, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, test__2.toArray());
    }

    @Test
    public void addAll() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {1, 5});
        ImmutableList test__2 = test_1.addAll(new Integer[] {43});
        Integer[] expected = {1, 5, 43};
        assertArrayEquals(expected, test__2.toArray());
    }

    @Test
    public void addAll1() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7});
        ImmutableList test__2 = test_1.addAll(0, new Integer[] {45, 2});
        Integer[] expected = {45, 2, 29, 7};
        assertArrayEquals(expected, test__2.toArray());
    }

    @Test
    public void get() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {5,4,3,2,1});
        int test__2 = (int) test_1.get(2);
        int expected = 3;
        assertEquals(expected, test__2);
    }

    @Test
    public void remove() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7});
        ImmutableList test__2 = test_1.remove(0);
        Integer[] expected = {7};
        assertArrayEquals(expected, test__2.toArray());

    }

    @Test
    public void set() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7, 4, 3});
        ImmutableList test__2 = test_1.set(2, 666);
        Integer[] expected = {29, 7, 666, 3};
        assertArrayEquals(expected, test__2.toArray());
    }

    @Test
    public void indexOf() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {100, 10});
        int test__2 = test_1.indexOf(10);
        int expected = 1;
        assertEquals(expected, test__2);
    }

    @Test
    public void size() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7});
        int test__2 = test_1.size();
        int expected = 2;
        assertEquals(expected, test__2);
    }

    @Test
    public void clear() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7});
        ImmutableList test__2 = test_1.addAll(0, new Integer[] {45, 2});
        Integer[] expected = {45, 2, 29, 7};
        assertArrayEquals(expected, test__2.toArray());
    }

    @Test
    public void isEmpty() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7});
        boolean test__2 = test_1.isEmpty();
        boolean expected = false;
        assertEquals(expected, test__2);
    }

    @Test
    public void toArray() throws Exception {
        ImmutableArrayList test_1 = new ImmutableArrayList(new Integer[] {29,7});
        java.lang.Object[] test__2 = test_1.toArray();
        Integer[] expected = {29, 7};
        assertArrayEquals(expected, test__2);

    }
    
}
