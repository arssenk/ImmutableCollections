package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void peek() throws Exception {
        Stack generel = new Stack();
        generel.add(1);
        generel.add(2);
        Object actual = generel.peek();
        Integer expected = 2;
       assertEquals(expected, actual);
    }

    @Test
    public void pop() throws Exception {
        Stack generel = new Stack();
        generel.add(1);
        generel.add(2);
        Object actual = generel.pop();
        Integer expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void add() throws Exception {
        Stack generel = new Stack();
        generel.add(1);
        generel.add(2);

        String expected = "2, 1";
        assertEquals(expected, generel.general.toString());
    }
}
