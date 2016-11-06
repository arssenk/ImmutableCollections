package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {


    @Test
    public void size() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(3));
        int expResult = 1;
        int actualResult = test1.size();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void add() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(3));

        ImmutableList test3 = test2.add(2);
        String expResult = "3, 2";
        assertEquals(expResult, test3.toString());

    }

    @Test
    public void add1() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(3));
        String expResult = "3, 8";
        ImmutableList test3 = test2.add(1, 8);
        assertEquals(expResult, test3.toString());
    }

    @Test
    public void addAll() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(3));
        String expResult = "3, 56, -1";
        ImmutableList test3 = test2.addAll(new Object[] { 56, -1});
        assertEquals(expResult, test3.toString());
    }

    @Test(expected = NullPointerException.class)
    public void addAll1() throws NullPointerException {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(3));
        String expResult = "3, 4, 31";
        ImmutableList test3 = test2.addAll(1, new Object[] {4,31});
    }

    @Test
    public void get() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(53));
        ImmutableList test3 = test2.addAll(0, new Object[] {5, 3, 1});
        Object k = test3.get(2);
        Integer expResult = 1;

        assertEquals(expResult, k);
    }

    @Test
    public void remove() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(10));
        ImmutableList test3 = test2.addAll(0, new Object[] {87, 6});
        ImmutableList answer = test3.remove(1);
        String expResult = "87, 10";

        assertEquals(expResult, answer.toString());
    }

    @Test
    public void set() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(34));
        ImmutableList test3 = test2.addAll(0, new Object[] {123, -5});
        ImmutableList answer = test3.set(2, 1);
        String expResult = "123, -5, 1";

        assertEquals(expResult, answer.toString());
    }

    @Test
    public void indexOf() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        ImmutableList test3 = test2.addAll(new Object[] {32,94});
        int answer = test3.indexOf(32);
        int expResult = 1;

        assertEquals(expResult, answer);
    }

    @Test
    public void clear() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        ImmutableList test3 = test2.addAll(0, new Object[] {32,94});
        ImmutableList answer = test3.clear();
        ImmutableLinkedList expResult = new ImmutableLinkedList(new Node(null));

        assertEquals(answer.toString(), expResult.toString());
    }

    @Test
    public void isEmpty() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        boolean answer = test2.isEmpty();
        boolean expResult = false;

        assertEquals(expResult, answer);
    }

    @Test
    public void toArray() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        ImmutableList answer = test2.add(2);
        Object[] finalAns = answer.toArray();
        Object[] expResult = {66, 2};

        assertEquals(expResult, finalAns);
    }

    @Test
    public void addFirst() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        ImmutableList test3 = test2.addFirst(0);
        ImmutableLinkedList expResult0 = new ImmutableLinkedList(new Node(0));
        ImmutableList expResult1 = expResult0.add(66);
        assertEquals(test3.toString(), expResult1.toString());
    }

    @Test
    public void addLast() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        test2.addLast(10);
        ImmutableLinkedList expResult0 = new ImmutableLinkedList(new Node(66));
        ImmutableList expResult1 = expResult0.add(10);
        assertEquals(test2.toString(), expResult1.toString());
    }

    @Test
    public void getFirst() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        Object test3 = test2.getFirst();
        Object expResult = 66;

        assertEquals(test3, expResult);

    }

    @Test
    public void getLast() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        test2.addFirst(3);
        Object test3 = test2.getLast();
        Object expResult = 66;
        assertEquals(test3, expResult);

    }

    @Test
    public void removeFirst() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        test2.addFirst(3);
        ImmutableList test3 = test2.removeFirst();
        ImmutableLinkedList expResult = new ImmutableLinkedList(new Node(3));
        assertEquals(test3.toString(), expResult.toString());

    }

    @Test
    public void removeLast() throws Exception {
        ImmutableLinkedList test2 = new ImmutableLinkedList(new Node(66));
        test2.addFirst(3);
        ImmutableList test3 = test2.removeLast();
        ImmutableLinkedList expResult = new ImmutableLinkedList(new Node(66));
        assertEquals(test3.toString(), expResult.toString());

    }
}
