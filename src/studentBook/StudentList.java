//package studentBook;
//
//
//import java.util.NoSuchElementException;
//
//public class StudentList<StudentNode>{
//    protected StudentNode head;
//    protected StudentNode tail;
//    private int size;
//
//    public StudentList(){
//        head = new StudentNode(null, null, null);
//        size = 0;
//        tail = new StudentNode(null, null, null);
//        head.setNext(tail);
//        tail.setBefore(head);
//    }
//
//    public int search(E target){
//        Node p = head;
//        for (int k =0;k < size; k++){
//            if (target == p.getItem()) return  k;
//            p = p.getNext();
//        }
//        return -1;
//    }
//
//    public void insertFront(E newItem){
//        head = new Node(newItem, head, null);
//        size++;
//    }
//
//    public void insertAfter(E newItem, Node p){
//        Node newNode = new Node(newItem, p.getNext(), p);
//        p.getNext().setBefore(newNode);
//        p.setNext(newNode);
//        size++;
//    }
//
//    public void deleteFront(){
//        if (size == 0) throw new NoSuchElementException();
//        head = head.getNext();
//        head.setBefore(null);
//        size--;
//    }
//
//    public void deleteAfter(Node p){
//        if (p == null) throw new NoSuchElementException();
//        Node N = p.getNext();
//        Node B = p.getBefore();
//        N.setBefore(B);
//        B.setNext(N);
//        p.setNext(null);
//        p.setBefore(null);
//        size --;
//    }
//}
//
