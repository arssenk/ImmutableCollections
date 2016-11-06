package ua.edu.ucu.collections.immutable;

/**
 * Created by Arsen on 03-Nov-16.
 */

class Node {
    Object data;
    Node next;
    Node(Object data1){
        this.data = data1;
    }
    Node(){
        this.data = null;
    }
    Node getNext(){
        return this.next;
    }
    Object getData(){
        return this.data;
    }
    Node setData(Object r){
        this.data = r;
        return null;
    }
    void setNext(Node e){
        this.next = e;
    }
    @Override
    public String toString(){
        return (String) this.data;
    }
    }

