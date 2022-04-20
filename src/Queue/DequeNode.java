package Queue;

/*
1. 데크 안에서 사용할 노드 객체
2. 이중연결 링크드리스트이다 보니 앞 노드와 뒷 노드를 가리키는 참조변수가 들어갈 곳을 모두 만듬
3. 거기에 내용물을 담을 item을 넣어 생성자를 만듬
4. 중간에 내용물을 꺼내 오류 시 검증을 해보기 위한 toString overriding을 구현
 */
public class DequeNode <E> {
    private E item;
    private DequeNode<E> next;
    private DequeNode<E> before;

    public String toString(){
        return item.toString();
    }
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
