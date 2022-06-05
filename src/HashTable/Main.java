package HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] random = new int[20];
        for (int i = 0; i < 20; i++) {
            random[i] = (int) (Math.random() * 20 + 1);
        }
        System.out.println(Arrays.toString(random));

        Chaining chaining = new Chaining(20);
        for (int i = 0; i < random.length; i++){
            chaining.saveData(Integer.toString(i), Integer.toString(random[i]));
        }
        TwoWayChaining twochaining = new TwoWayChaining(20);
        for (int i = 0; i < random.length; i++){
            twochaining.saveData(Integer.toString(i), random[i]);
            System.out.println(twochaining.hashTable[chaining.hasFunc(Integer.toString(i))].size);
        }

        twochaining.saveData("24", 123);
        twochaining.saveData("12", 123);
        twochaining.saveData("24", 123);
        twochaining.saveData("145", 123);
        twochaining.saveData("25", 123);

        /*
          1. hash table test
          2. chaining test
         */
//        HashTable hashTest = new HashTable(20);
//        hashTest.saveData("123", "hihi");
//        hashTest.saveData("143", "hihi1");
//        hashTest.saveData("153", "hihi2");
//
//        String abc = hashTest.getData("123");
//        String abc1 = hashTest.getData("143");
//        String abc2 = hashTest.getData("153");
//
//        System.out.println(abc);
//        System.out.println(abc1);
//        System.out.println(abc2);
//
//        Chaining chaning = new Chaining(20);
//        chaning.saveData("234", "hihi");
//        chaning.saveData("263", "hihi1");
//        chaning.saveData("283", "hihi2");
//
//        String def = chaning.getData("234");
//        String def1 = chaning.getData("263");
//        String def2 = chaning.getData("283");
//
//        System.out.println(def);
//        System.out.println(def1);
//        System.out.println(def2);
    }
}

