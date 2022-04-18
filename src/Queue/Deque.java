package Queue;

public class Deque<E> {
    private DequeNode<E> front, rear;
    private int size;

    public DequeNode<E> getFront(){
        return front;
    }

    public DequeNode<E> getRear(){
        return rear;
    }

    public int getSize(){
        return size;
    }

    public Deque(){
        this.front = new DequeNode<>(null, null, null);
        this.rear = new DequeNode<>(null, front, front);
        front.setNext(rear);
        front.setBefore(rear);
        this.size = 0;
    }

    public void insertFront(E item){
        DequeNode<E> newNode = new DequeNode<>(item, front.getNext(), front);
        front.getNext().setBefore(newNode);
        front.setNext(newNode);
        size ++;
    }
    public void insertLast(E item){
        DequeNode<E> newNode = new DequeNode<>(item, rear, rear.getBefore());
        rear.getBefore().setNext(newNode);
        rear.setBefore(newNode);
        size ++;
    }
    public DequeNode<E> removeFirst(){
        DequeNode<E> removedNode = front.getNext();
        removedNode.getNext().setBefore(front);
        front.setNext(removedNode.getNext());
        size --;
        return removedNode;
    }
    public DequeNode<E> removeLast(){
        DequeNode<E> removedNode = rear.getBefore();
        removedNode.getBefore().setNext(rear);
        rear.setBefore(removedNode.getBefore());
        size --;
        return removedNode;
    }


}
