package QuickSort;

import java.util.ArrayList;
import java.util.Scanner;

/*
Arraylist 로 퀵 정렬 구현

quick sort
- ArrayList 를 인자로 받아 기준이 되는 pivot 이 들어가는 ArrayList, 기준보다 크기가 작은 수들이 들어가근 Left, 큰 수들이 들어가는 Right ArrayList 를 생성
- for 문을 돌며 최초의 Arraylist 를 각각 저장
- 각 ArrayList 를 합쳐서 정렬된 ArrayList 를 생성
    * 이 과정에서 left 와 right 에 재귀함수를 걸어 내부적으로 sorting 을 완료시킨다
- 최종적으로 정렬된 배열 반환

 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("10개의 숫자를 띄어쓰기로 구분하여 입력하시오");
        ArrayList<Integer> unsortedData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            unsortedData.add(sc.nextInt());
        }

        Sort sort = new Sort();
        ArrayList<Integer> sortedData = sort.sorting(unsortedData);

        System.out.println("최종 정렬: ");
        for (Integer sortedDatum : sortedData) {
            System.out.print(sortedDatum + " ");
        }
    }
}

class Sort {
    public ArrayList<Integer> sorting(ArrayList<Integer> unsortedData) {
        if (unsortedData.size() <= 1) {
            return unsortedData;
        }

        int pivot = unsortedData.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> pivotList = new ArrayList<>();

        pivotList.add(pivot);

        for (int i = 1; i < unsortedData.size(); i++) {
            if (unsortedData.get(i) < pivot) {
                left.add(unsortedData.get(i));
            } else {
                right.add(unsortedData.get(i));
            }
        }

        ArrayList<Integer> middleResult = new ArrayList<>();
        middleResult.addAll(left);
        middleResult.addAll(pivotList);
        middleResult.addAll(right);

        System.out.println("정렬 출력: ");
        for (Integer integer : middleResult) {
            System.out.print(integer + " ");
        }
        System.out.println();

        ArrayList<Integer> sortedList = new ArrayList<>(this.sorting(left));  // 어차피 더할 거 이 ArrayList로 생성
        sortedList.addAll(pivotList);
        sortedList.addAll(this.sorting(right));
        return sortedList;
    }
}