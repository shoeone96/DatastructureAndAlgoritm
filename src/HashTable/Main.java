package HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] random = new int[20];
        for (int i = 0; i < 20; i++) {
            random[i] = (int) (Math.random() * 20 + 1);
        }
        System.out.println(Arrays.toString(random));

    }
}

