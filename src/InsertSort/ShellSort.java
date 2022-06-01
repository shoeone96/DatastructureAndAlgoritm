package InsertSort;

import java.util.ArrayList;
import java.util.Collections;

/*
shell short
 */
public class ShellSort {
    public ArrayList<Integer> shellSort(ArrayList<Integer> unsortedList) {
        int interval = 4;
        while (interval != 0) {
            for (int i = 0; i < unsortedList.size() - interval; i++) {
                if (unsortedList.get(i + interval) < unsortedList.get(i)) {
                    Collections.swap(unsortedList, i, i + interval);
                }
            }
            interval--;
        }
        return unsortedList;
    }


}
