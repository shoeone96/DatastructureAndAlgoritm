package DoublyLinkedList;

import java.util.NoSuchElementException;

public class SList<E> {
    protected Node<E> head;
    protected Node<E> tail;
    private int size;

    public SList() {
        head = new Node(null, null, null);
        size = 0;
        tail = new Node(null, null, null);
        head.setNext(tail);
        tail.setBefore(head);
    }

    public int getSize() {
        return size;
    }

    public int search(E target) {
        Node p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1;
    }

    public void insertFront(E newItem) {
        Node newNode = new Node(newItem, null, head);
        head.getNext().setBefore(newNode);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        size++;
    }

    public void insertAfter(E newItem, Node p) {
        Node newNode = new Node(newItem, p.getNext(), p);
        p.getNext().setBefore(newNode);
        p.setNext(newNode);
        size++;
    }

    public void deleteFront() {
        if (size == 0) throw new NoSuchElementException();
        head = head.getNext();
        head.setBefore(null);
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node N = p.getNext();
        Node B = p.getBefore();
        N.setBefore(B);
        B.setNext(N);
        size--;
    }
}

