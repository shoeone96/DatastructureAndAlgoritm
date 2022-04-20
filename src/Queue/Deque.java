package Queue;


/*
1. 이중연결 링크드리스트를 원형으로 이어 만든 데크
2. 이중연결 링크드리스트가 기본이기에 맨 앞과 맨 뒤에 front와 rear를 빈 공간으로 두고 그 사이에 연결하는 방식으로 만듬
3. 앞에 추가하는 방식과 뒤에 추가하는 방식, 앞에 삭제하는 것과 뒤에 삭제하는 것을 기본으로 만듬(스택과 큐의 성격을 동시에 같는 데크의 구조)
4. 추가로 편의를 위해 중간 삭제하는 메서드도 만듬
5. 비어있는지를 확인하기 위해 empty 메서드도 추가
 */
public class Deque<E> {
    private DequeNode<E> front, rear;
    private int size;

    public DequeNode<E> getFront() {
        return front;
    }

    public DequeNode<E> getRear() {
        return rear;
    }

    public int getSize() {
        return size;
    }


    public Deque() {
        this.front = new DequeNode<>(null, null, null);
        this.rear = new DequeNode<>(null, front, front);
        front.setNext(rear);
        front.setBefore(rear);
        this.size = 0;
    }

    public void insertFront(E item) {
        DequeNode<E> newNode = new DequeNode<>(item, front.getNext(), front);
        front.getNext().setBefore(newNode);
        front.setNext(newNode);
        size++;
    }

    public void insertLast(E item) {
        DequeNode<E> newNode = new DequeNode<>(item, rear, rear.getBefore());
        rear.getBefore().setNext(newNode);
        rear.setBefore(newNode);
        size++;
    }

    public DequeNode<E> removeFirst() {
        DequeNode<E> removedNode = front.getNext();
        removedNode.getNext().setBefore(front);
        front.setNext(removedNode.getNext());
        size--;
        return removedNode;
    }

    public DequeNode<E> removeLast() {
        DequeNode<E> removedNode = rear.getBefore();
        removedNode.getBefore().setNext(rear);
        rear.setBefore(removedNode.getBefore());
        size--;
        return removedNode;
    }

    public void removeMiddle(DequeNode<E> node) {
        node.getNext().setBefore(node.getBefore());
        node.getBefore().setNext(node.getNext());
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
