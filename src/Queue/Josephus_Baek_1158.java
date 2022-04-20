package Queue;

import java.util.Arrays;
import java.util.Scanner;
/*
이중 연결 링크드리스트로 구현한 원형데크로 요세푸스 문제 해결
1. 몇 개의 크기의 데크를 선언할지 그리고 몇 번째 숫자마다 출력하여 새로운 배열에 넣을지 설정
2. 순차적으로 정해진 N이라는 숫자까지 진행하며 데크노드에 숫자를 담아 데크에 저장
3. 실제로 성공적으로 값이 담겼는지 확인
4. 요세푸스 문제를 풀 배열을 생성한다.
5. 정확히 배열의 몇 번째에 K 번째 숫자를 담을지 설정하기 위해 size 도 만든다.
6. for 문을 통해 k 번 노드를 이동한 후 해당 노드에 담긴 숫자를 배열에 넣고 데크에서는 삭제하는 작업을 진행
7. front와 rear가 비어있는 경우이기 때문에 nullPointException이 발생하지 않도록 front와 rear를 만나면 건너뛸 수 있게 if 문 설정
8. 숫자가 담기고 데크에서 노드가 하나씩 사라질 때마다 데크 안의 데이터 상태를 확인
9. 최종적으로 다 담기면 요세푸스 배열을 출력
** 마지막 데크에 3개의 노드(front, rear 제외)만 담겨있을 때 k가 3인 경우 3번 움직이면 rear나 front로 다시 회기하는 문제가 발생하여 if 문을 내부적으로 한 번 더 작성
 */

public class Josephus_Baek_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Deque<DequeNode<Integer>> JosephusDeque = new Deque<>();
        for (int i = 1; i <= N; i++) {
            DequeNode<Integer> num = new DequeNode<>(i, null, null);
            // 순서대로 넣기 위해 마지막에 삽입
            JosephusDeque.insertLast(num);
        }

        // 시험 출력
//        DequeNode<DequeNode<Integer>> temp = JosephusDeque.getFront();
//        while (temp != JosephusDeque.getRear().getBefore()){
//            System.out.print(temp.getNext().getItem().getItem() + " ");
//            temp = temp.getNext();
//        }
        // 출력 결과 성공
        // 6 6 (input)
        // 1 2 3 4 5 6 (result)

        int[] JosephusArray = new int[N];
        int size = 0;
        DequeNode<DequeNode<Integer>> targetNode = JosephusDeque.getFront();
        while (size != N) {
            for (int i = 0; i < K; i ++){
                if (targetNode == JosephusDeque.getRear().getBefore()) {
                    targetNode = targetNode.getNext().getNext().getNext();
                } else if (targetNode == JosephusDeque.getRear()){
                    targetNode = targetNode.getNext().getNext();
                } else if( targetNode == JosephusDeque.getFront()){
                  targetNode = targetNode.getNext();
                } else {
                    targetNode = targetNode.getNext();
                    if (targetNode == JosephusDeque.getRear()){
                        targetNode = targetNode.getNext().getNext();
                    }else if (targetNode == JosephusDeque.getFront()){
                        targetNode = targetNode.getNext();
                    }
                }
            }
            JosephusArray[size++] = targetNode.getItem().getItem();
            System.out.println(JosephusArray[size-1] + " 저장 ");
            JosephusDeque.removeMiddle(targetNode);
            DequeNode<DequeNode<Integer>> temp = JosephusDeque.getFront();
        while (temp != JosephusDeque.getRear().getBefore()){
            System.out.print(temp.getNext().getItem().getItem() + " ");
            temp = temp.getNext();
        }
            System.out.println("----- 데크");
        }
        System.out.println("요세푸스 문제: " + Arrays.toString(JosephusArray));
    }
}
