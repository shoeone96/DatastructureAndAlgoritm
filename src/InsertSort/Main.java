package InsertSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


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
        array = insertSort.insertSort(array);
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }

        System.out.println("Shell Sort Operation");
        System.out.println("8개의 숫자를 입력하시오(띄어쓰기로 구분)");
        ArrayList<Integer> array2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            array2.add(scanner.nextInt());
        }
        ShellSort shellSort = new ShellSort();
        array2 = shellSort.shellSort(array2);

        for (Integer integer : array2) {
            System.out.print(integer + " ");
        }
    }

}

class InsertSort {
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
/*
shell short
일정 간격을 설정하고 간격 별로 처리 진행

 */
class ShellSort {
    public ArrayList<Integer>  shellSort(ArrayList<Integer> unsortedList){
        int interval = 4;
        while(interval != 0){
            for (int i = 0; i < unsortedList.size()-interval; i++){
                if (unsortedList.get(i+interval) < unsortedList.get(i)){
                    Collections.swap(unsortedList, i, i+interval);
                }
            }
            interval --;
        }
        return unsortedList;
    }


}