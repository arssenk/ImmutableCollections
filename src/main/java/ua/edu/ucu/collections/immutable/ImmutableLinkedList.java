package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    final private Node head;

    public ImmutableLinkedList() {
        this.head = new Node(null);
    }

    ImmutableLinkedList(Node el) {
        this.head = el;
    }

    private ImmutableLinkedList clone(Node e) {
        if (e.data == null) {
            return new ImmutableLinkedList(new Node());
        } else if (e.next == null) {
            return new ImmutableLinkedList(new Node(e.data));
        }
        Node newHead = new Node(e.data);
        Node current = new Node();
        newHead.next = current;
        while (e.next != null) {
            e = e.next;
            current.data = e.data;
            if (e.next != null) {
                current.next = new Node();
                current = current.next;
            }
        }
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public int size() {
        int i = 0;
        Node current = this.head;
        while (current.next != null) {
            i++;
            current = current.next;
        }
        return i + 1;
    }

    @Override
    public ImmutableList add(java.lang.Object e) {
        ImmutableLinkedList tmp = this.clone(this.head);
        if (tmp.head.getData() == null) {
            tmp.head.setData(e);
        } else {
            Node new_node = new Node(e);
            Node start = tmp.head;
            while (start.getNext() != null) {
                start = start.next;
            }
            start.setNext(new_node);
        }
        return tmp;
    }

    @Override
    public ImmutableList add(int index, java.lang.Object e) {
        ImmutableLinkedList tmp = this.clone(this.head);
        int size = this.size();
        if (index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        Node newNode = new Node(e);
        if (index == 0) {
            newNode.setNext(tmp.head);
            return tmp;
        } else {
            int i = 0;
            Node start = tmp.head;
            while (i < index - 1) {
                i++;
                start = start.getNext();
            }
            Node nextNode = start.next;
            start.setNext(newNode);
            newNode.setNext(nextNode);
        }
        return tmp;
    }

    @Override
    public ImmutableList addAll(java.lang.Object[] c) {
        ImmutableLinkedList tmp = this.clone(this.head);
        for (java.lang.Object i : c) {
            Node start = tmp.head;
            while (start.next != null) {
                start = start.getNext();
            }
            start.next = new Node(i);
        }
        return tmp;
    }
    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ImmutableLinkedList tmp = this.clone(this.head);
        if (index > tmp.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        } else {
            int tempIndex = index;

            for (Object k : c) {
                Node newNode = new Node(k);

                if (tempIndex == 0) {
                    Node tempHead = new Node();
                    tempHead.data = tmp.head.data;
                    tempHead.next = tmp.head.next;
                    tmp.head.data = newNode.data;
                    tmp.head.next = tempHead;
                    tempIndex++;
                } else if (tempIndex == 1) {
                    Node temp = new Node(tmp.head.next.data);
                    temp.next = tmp.head.next.next;
                    tmp.head.next = newNode;
                    newNode.next = temp;
                    tempIndex++;
                } else {
                    int i = 0;
                    Node start = tmp.head;
                    while (i < tempIndex - 2) {
                        i++;
                        start = start.getNext();
                    }
                    Node nextNode = start.next;
                    start.setNext(newNode);
                    newNode.setNext(nextNode);
                }
                tempIndex++;
            }
            return tmp;
        }

    }

    @Override
    public Object get(int index) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        } else {
            int i = 0;
            Node start = this.head;
            while (i < index) {
                start = start.next;
                i++;
            }
            return start.data;
        }

    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableLinkedList tmp = this.clone(this.head);

        if (index > tmp.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        } else {
            int i = 0;
            Node start = tmp.head;
            while (i < index - 1) {
                start = start.next;
                i++;
            }
            start.next = start.next.next;
            return tmp;
        }
    }

    @Override
    public ImmutableList set(int index, java.lang.Object e) {
        int i = 0;
        ImmutableLinkedList tmp = this.clone(this.head);
        Node start = tmp.head;
        while (i < index) {
            start = start.next;
            i++;
        }
        start.data = e;
        return tmp;

    }

    @Override
    public int indexOf(Object e) {
        ImmutableLinkedList tmp = this.clone(this.head);
        int i = 0;
        Node start = tmp.head;
        while (start.data != e && start.next != null) {
            i++;
            start = start.next;
        }
        if (i == tmp.size() - 1 && start.data != e) {
            return -1;
        }
        return i;

    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList(new Node(null));
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Object[] toArray() {
        Object[] n = new Object[this.size()];
        Node start = this.head;
        for (int i = 0; i < this.size(); i++) {
            n[i] = start.data;
            start = start.next;
        }
        return n;
    }


    public ImmutableLinkedList addFirst(Object e) {
        if (this.head.data == null) {
            this.head.data = e;
            return this;
        }
        Node tmp1 = new Node(this.head.data);
        if ( head.next != null){
        tmp1 = new Node(this.head.data);
        tmp1.next = this.head.next;
        this.head.data = e;
        this.head.next = tmp1;
        return this;}
        else{
            this.head.data = e;
            this.head.next = tmp1;
            return this;
        }
    }

    public ImmutableLinkedList addLast(Object e) {
        Node start = this.head;
        if (start.data == null){
            start.data = e;
            return this;
        }
        while (start.next != null) {
            start = start.next;
        }
        start.next = new Node(e);
        return this;
    }

    public Object getFirst() {
        return this.head.data;
    }

    Object getLast() {
        Node start = this.head;
        while (start.next != null) {
            start = start.next;
        }
        return start.data;
    }

    public ImmutableLinkedList removeFirst() {
        Node start = this.head;
        Object tmp = this.head.data;
        while (start.next != null && start.next.next != null) {
            start.data = start.next.data;
            start = start.next;

        }
        start.next = null;

        return this;
    }

    ImmutableLinkedList removeLast() {
        Node start = this.head;
        while (start.next != null && start.next.next != null) {
            start = start.next;
        }
        ImmutableLinkedList tmp = new ImmutableLinkedList(start.next);
        start.next = null;

        return tmp;
    }

    @Override
    public String toString() {
        String a = "";
        Node start = this.head;
        a += start.getData();
        while (start.getNext() != null) {
            start = start.next;
            a += ", " + start.getData();
        }
        return a;
    }
}