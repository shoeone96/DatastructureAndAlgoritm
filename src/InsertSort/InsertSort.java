package InsertSort;

import java.util.ArrayList;
import java.util.Collections;

/*
Insert Sort 구현 메서드
 */
public class InsertSort {
    public ArrayList<Integer> insertSort(ArrayList<Integer> unsortedList) {
        for (int i = 0; i < unsortedList.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (unsortedList.get(j) < unsortedList.get(j - 1)) {
                    Collections.swap(unsortedList, j, j - 1);
                } else break;
            }
        }
        return unsortedList;
    }
}
