package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arsen on 06-Nov-16.
 */
public class NodeTest {
    @Test
    public void getNext() throws Exception {
        Node test_1= new Node(4);
        test_1.next = new Node(5);
        Node test_final = test_1.getNext();
        Node expected = new Node(5);
        assertEquals(expected.data, test_final.data);
    }

    @Test
    public void getData() throws Exception {
        Node test_1= new Node(4);
        Object test_final = test_1.getData();
        int expected = 4;
        assertEquals(expected, test_final);
    }

    @Test
    public void setData() throws Exception {
        Node test_1= new Node(4);
        Node test_final = test_1.setData(42);
        Node expected = new Node(42);
        assertEquals(expected.data, test_1.data);
    }

    @Test
    public void setNext() throws Exception {
        Node test_1= new Node(4);
        test_1.setNext(new Node(5));
        Node expected = new Node(5);
        assertEquals(expected.data, test_1.next.data);

    }

}