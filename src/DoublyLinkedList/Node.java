package DoublyLinkedList;

public class Node<E>{
    private E item;
    private Node<E> next;
    private Node<E> before;

    public Node(E item, Node next, Node before){
        this.item = item;
        this.next = next;
        this.before = before;
    }

    public String toString(){
        return item.toString();
    }

    public E getItem() { return item; }
    public Node<E> getNext() { return next;}
    public Node<E> getBefore() { return before;}

    public void setItem(E item) { this.item = item; }
    public void setNext(Node<E> next) {this.next = next; }
    public void setBefore(Node<E> before) {this.before = before; }
}
