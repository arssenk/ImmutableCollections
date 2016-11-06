package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList general;

    public Queue() {
        general = new ImmutableLinkedList();
    }

    Object peek(){
        return general.getFirst();
    }
    Object dequeue(){
        Object tmp = this.general.get(0);
        this.general.removeFirst();
        return tmp;
    }
    void enqueue(Object e){
        this.general.addLast(e);
    }
    public String toString(){
        return general.toString();
    }
}
