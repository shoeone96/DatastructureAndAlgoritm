package InsertSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Insert Sort 와 Shell Sort 구현 및 성능 비교 작업
1. ArrayList 를 통한 InsertSort 의 메서드 구현
2. ArrayList 를 통한 ShellSort 의 메서드 구현
3. 동일한 ArrayList 를 형성 후 정렬 메서드 성능 비교
- 사용된 배열 [23 6 1 23 7 43 16 85] 의 정렬
- 초기 System.currentTimeMillis();을 통해 메서드 시간의 차이를 구하려 했으나 둘 다 0이 나와 더 세밀한 시간 측정이 필요함을 확인
- System.nanoTime();으로 변경하여 시간 측정

Insert Sort Operation Time: 655ns
Shell Sort Operation Time: 513ns

위와 같은 실행 시간의 차이를 확인
Shell Sort 가 Insert Sort 보다 빠른 성능을 가졌음을 확인
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert Sort Operation");
        System.out.println("8개의 숫자를 입력하시오(띄어쓰기로 구분)");
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            array.add(scanner.nextInt());
        }

        InsertSort insertSort = new InsertSort();
        long beforeInsert = System.nanoTime();
        array = insertSort.insertSort(array);
        long afterInsert = System.nanoTime();
        long insertOperationTime = (afterInsert - beforeInsert) / 1000;

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println("Shell Sort Operation");
        System.out.println("8개의 숫자를 입력하시오(띄어쓰기로 구분)");
        ArrayList<Integer> array2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            array2.add(scanner.nextInt());
        }

        ShellSort shellSort = new ShellSort();
        long beforeShell = System.nanoTime();
        array2 = shellSort.shellSort(array2);
        long afterShell = System.nanoTime();
        long shellOperationTime = (afterShell - beforeShell) / 1000;

        for (Integer integer : array2) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println("Insert Sort Operation Time: " + insertOperationTime + "ns");
        System.out.println("Shell Sort Operation Time: " + shellOperationTime + "ns");
    }

}

