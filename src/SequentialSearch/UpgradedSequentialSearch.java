package SequentialSearch;

import java.util.ArrayList;

public class UpgradedSequentialSearch {

    public int SequentialSearch(ArrayList<Integer> array, int key) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == key) {
                return array.indexOf(key);
            }
        }
        return -1;
    }


    public int upgradedSequentialSearch(ArrayList<Integer> array, int key) {
        array.add(key);
        int i;
        for (i = 0; i < array.size() - 2; i++) {
            System.out.println("현재 총 " + (array.size() - 1) + "개의 데이터 중 " + (i+1) + "번째 데이터를 검사하고 있습니다.");
            if (array.get(i) == key) {
                System.out.println("조건에 부합하는 데이터의 위치를 찾아 탐색을 종료합니다.");
                return i;

            }
        }
        System.out.println("원하시는 데이터를 찾지 못하였습니다.");
        return -1;
    }
}