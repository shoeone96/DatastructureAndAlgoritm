package Queue;

public class DequeNode <E> {
    private E item;
    private DequeNode<E> next;
    private DequeNode<E> before;

    public DequeNode(){}
    public DequeNode(E item, DequeNode<E> next, DequeNode<E> before){
        this.item = item;
        this.next = next;
        this.before = before;
    }

    public void setNext(DequeNode<E> next){
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public DequeNode<E> getNext() {
        return next;
    }

    public DequeNode<E> getBefore() {
        return before;
    }

    public void setBefore(DequeNode<E> before) {
        this.before = before;
    }
}
