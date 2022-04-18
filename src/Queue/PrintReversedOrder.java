package Queue;

import java.util.Scanner;

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
