package InsertSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("8개의 숫자를 입력하시오(띄어쓰기로 구분)");
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            array.add(scanner.nextInt());
        }

        InsertSort insertSort = new InsertSort();
        insertSort.sort(array);

        for (int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
    }

}

class InsertSort {
    public ArrayList<Integer> sort(ArrayList<Integer> unsortedList){
        for (int i = 0; i < unsortedList.size() - 1; i++){
            for (int j = i+1; j >0; j--){
                if(unsortedList.get(j) < unsortedList.get(j-1)){
                    Collections.swap(unsortedList, j, j-1);
                }else break;
            }
        }
        return unsortedList;
    }
}

class ShellSort{
    
}