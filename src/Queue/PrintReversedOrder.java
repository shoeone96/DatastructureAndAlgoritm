package Queue;

import java.util.Scanner;
/*
1. 숫자를 노드에 담아 저장한 뒤 출력하는 프로그래밍
2. 숫자만 들어가는 Inteager generics 타입의 데크 생성
3. 들어갈 숫자의 개수와 숫자를 입력받아 1차적으로 배열에 넣는다
4. 그 이후 배열에서 숫자를 하나씩 뽑아 데크 안에 저장한다
5. 이때 역순으로 꺼내기 편하도록 새로운 노드를 앞에 계속 붙임(이중연결 링크드리스트라 O(1)만큼만 소비
6. 저장 후 데크의 앞에서부터 마지막까지 while문을 돌며 print
 */
public class PrintReversedOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<DequeNode<Integer>> numberDeque = new Deque<>();
        System.out.println("넣을 숫자의 개수를 입력하시오");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.println("숫자를 한 칸 단위로 입력해주세요");

        for (int number = 0; number < numbers.length; number++){
            numbers[number] = scanner.nextInt();
            DequeNode<Integer> newNode = new DequeNode<>(numbers[number], null, null);
            numberDeque.insertFront(newNode);
        }

        DequeNode<DequeNode<Integer>> temp = numberDeque.getFront();
        while (temp != numberDeque.getRear().getBefore()){
            System.out.print(temp.getNext().getItem().getItem() + " ");
            temp = temp.getNext();
        }
    }
}
