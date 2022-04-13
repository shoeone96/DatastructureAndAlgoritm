package LinkedList;

public class Node<E> {
    private E item;
    private Node<E> next;
    public Node(E newItem, Node<E> node){
        this.item = newItem;
        this.next = node;
    }
    public E getItem() { return item;}
    public Node<E> getNext() { return next;}
    public void setItem(E newItem) { this.item = newItem;}
    public void setNext(Node<E> next) { this.next = next;}
}

