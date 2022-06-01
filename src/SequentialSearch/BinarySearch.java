package SequentialSearch;

import java.util.ArrayList;

public class BinarySearch {

    public int binarySearch(ArrayList<Integer> array, int key, int start, int end) {
        if (end - start == 0 && array.get(start) != key) return -1;
        int binaryPoint = (start + end) / 2;
        System.out.println("중간지점: " + binaryPoint);

        if (array.get(binaryPoint) == key) {
            System.out.println("찾으시는 데이터의 위치를 확인하였습니다.");
            return binaryPoint;
        } else if (array.get(binaryPoint) < key) {
            System.out.println("binary point에 위치한 값이 찾으시는 값보다 작아 그보다 큰 범위에서 다시 탐색합니다.");
            System.out.println("시작점을 " + (start + 1) + ", 마지막을 " + (end + 1) + "로 지정하고 다시 탐색합니다.");
            return binarySearch(array, key, binaryPoint + 1, end);
        } else {
            System.out.println("binary point에 위치한 값이 찾으시는 값보다 커 그보다 작은 범위에서 다시 탐색합니다.");
            System.out.println("시작점을 " + (start + 1) + ", 마지막을 " + (end + 1) + "로 지정하고 다시 탐색합니다.");
            return binarySearch(array, key, start, binaryPoint - 1);
        }
    }
}
