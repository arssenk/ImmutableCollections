package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack{
    ImmutableLinkedList general;
    Stack() {
        this.general = new ImmutableLinkedList();
    }
    Object peek(){
        return this.general.getFirst();
    }

    Object pop(){
        Object tmp = this.general.get(0);
        this.general.removeFirst();
        return tmp;
    }
    void add(Object e){
        this.general.addFirst(e);
    }
    public static void main(String[] s){
        Stack generel = new Stack();
        generel.add(1);
        generel.add(2);
    }
}
