package SequentialSearch;

import java.util.ArrayList;

/*
이진 탐색 구현
 */
public class BinarySearch {

    // 시작점과 끝점, 찾아려는 값, 배열을 삽입하여 진행
    public int binarySearch(ArrayList<Integer> array, int key, int start, int end) {
        if (end - start == 0 && array.get(start) != key) return -1; // 마지막까지 값을 찾아도 나오지 않을 때 -1 반환으로 값이 없음을 알림
        int binaryPoint = (start + end) / 2; // 이진트리 찾는 지점
        System.out.println("중간지점: " + binaryPoint);

        // 중간지점과 key 값을 비교해
        // key 값이 더 크면 end 지점을 (중간지점-1)로 변경
        // key 값이 더 작으면 start 지점을 (중간지점+1)로 변경
        // 각각 Recursion 적용
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
