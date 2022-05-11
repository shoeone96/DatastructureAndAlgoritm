package QuickSort;

import java.util.ArrayList;
import java.util.Scanner;

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
        for (int i = 0; i < sortedData.size(); i++){
            System.out.print(sortedData.get(i) + " ");
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
        for (int i = 0; i< middleResult.size(); i++){
            System.out.print(middleResult.get(i) + " ");
        }
        System.out.println();

        ArrayList<Integer> sortedList = new ArrayList<>(this.sorting(left));  // 어차피 더할 거 이 ArrayList로 생성
        sortedList.addAll(pivotList);
        sortedList.addAll(this.sorting(right));
        return sortedList;
    }
}