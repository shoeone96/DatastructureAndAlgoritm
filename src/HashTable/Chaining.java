package HashTable;

import java.util.Arrays;

public class Chaining {

    public Slot[] chaining;


    public Chaining(Integer size) {
        this.chaining = new Slot[size];
    }


    public class Slot {

        String key;
        String value;
        Slot next;

        Slot(String key, String value) {
            this.value = value;
            this.key = key;
            this.next = null;
        }
    }


    public int hasFunc(String key) {
        return (int) (key.charAt(0)) % this.chaining.length;
    }


    public boolean saveData(String key, String value) {
        Integer address = this.hasFunc(key);
        if (this.chaining[address] != null) {
            Slot findSlot = this.chaining[address];
            Slot prevSlot = this.chaining[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    findSlot.value = value;
                    return true;
                }else prevSlot = findSlot;
                findSlot = findSlot.next;
            }
            prevSlot.next = new Slot(key, value);
        } else this.chaining[address] = new Slot(key, value);
        System.out.println(Arrays.toString(chaining));

        return true;
    }


    public String getData(String key) {
        int address = this.hasFunc(key);
        Slot findSlot = chaining[address];
        if (findSlot != null) {
            while(findSlot != null){
                if(findSlot.key.equals(key)){
                    return findSlot.value;
                }else findSlot = findSlot.next;
            }
        }
        return null;
    }
}
