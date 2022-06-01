package SequentialSearch;

import InsertSort.InsertSort;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1번 문제
        System.out.println("1번 순차탐색");
        int random = (int) (Math.random() * 99 + 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        UpgradedSequentialSearch uss = new UpgradedSequentialSearch();

        for (int i = 0; i < random; i++) {
            arrayList.add((int) (Math.random() * 99 + 1));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("찾고자 하는 숫자를 입력하세요>> ");
        int key = scanner.nextInt();

        int index = uss.upgradedSequentialSearch(arrayList, key);

        if (index == -1) {
            System.out.println("찾으시는 숫자가 배열에 존재하지 않습니다.");
        } else {
            System.out.println("찾으시는 숫자는 배열의 " + index + "번째에 존재합니다.");
            System.out.println("찾으시는 데이터: " + key + ", " + "배열의" + (index + 1) + "번째 데이터: " + arrayList.get(index));
        }

        // 2번 문제
        System.out.println("2번 이진탐색");
        ArrayList<Integer> binarySearchArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            binarySearchArrayList.add((int) (Math.random() * 99 + 1));
        }
        for (int i = 0; i < binarySearchArrayList.size(); i++) {
            System.out.print(binarySearchArrayList.get(i) + " ");
        }
        System.out.println("");

        // 삽입정렬을 통한 정렬
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(binarySearchArrayList);
        System.out.println("정렬 진행");
        for (Integer integer : binarySearchArrayList) {
            System.out.print(integer + " ");
        }

        BinarySearch binarySearch = new BinarySearch();
        System.out.println("");
        System.out.print("찾고자 하는 숫자를 입력하세요>> ");
        int key2 = scanner.nextInt();
        int index2 = binarySearch.binarySearch(binarySearchArrayList, key2, 0, binarySearchArrayList.size() - 1);
        if (index == -1) {
            System.out.println("찾으시는 숫자가 배열에 존재하지 않습니다.");
        } else System.out.println("찾으시는 숫자는 배열의 " + index2 + "번째에 존재합니다.");
        scanner.close();
    }
}

