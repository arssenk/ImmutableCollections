package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void peek() throws Exception {
        Queue general = new Queue();
        general.enqueue(1);
        general.enqueue(2);
        general.enqueue(3);
        Object finalAnsw = general.peek();
        Object expected = 1;
        assertEquals(expected, finalAnsw);

    }

    @Test
    public void dequeue() throws Exception {
        Queue general = new Queue();
        general.enqueue(1);
        general.enqueue(2);
        general.enqueue(3);
        Object finalAnsw = general.dequeue();
        Object expected = 1;
        assertEquals(expected.toString(), finalAnsw.toString());

    }

    @Test
    public void enqueue() throws Exception {
        Queue general = new Queue();
        general.enqueue(1);
        general.enqueue(2);
        String finalAnsw = "1, 2";
        assertEquals(general.toString(), finalAnsw);
    }
}
