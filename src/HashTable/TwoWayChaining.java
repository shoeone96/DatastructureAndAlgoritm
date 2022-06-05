package HashTable;

import java.util.Arrays;

/*
  이번 과정에서 int 값으로만 진행되기 때문에 key 와 value 값 모두 int 로 진행
 */
public class TwoWayChaining {

    public TwoWayChaining(int size) {
        this.hashTable = new Bucket[size];
    }

    Bucket[] hashTable;


    class Bucket {
        String key;
        int value;
        int size;
        Bucket next;

        public Bucket(String key, int value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.next = null;
        }
    }


    public int hasFunc_1(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public int hasFunc_2(String key) {
        return ((int) (key.charAt(0)) + 1) % this.hashTable.length;
    }

    /*
      값을 저장하는 과정
      1. 해쉬 함수 1과 해쉬 함수 2를 진행
      2. 해쉬 함수 1을 통해 얻은 hash table 의 원소와 해쉬 함수 2를 통해 얻은 hash table 의 원소를 비교
      3. 만약 1의 사이즈가 2의 사이즈(사이즈는 뒤에 연결된 링크드 리스트의 개수를 의미)
      4. 사이즈에서 차이가 나지 않는다면 hash func_1 에서 나온 값으로 저장
      4. hash_1 에서 나온 것보다 hash_2 에서 나온 index 의 사이즈가 더 작다면 거기에 링크드리스트를 달아줌
     */
    public int saveData(String key, int value) {
        Integer address_1 = this.hasFunc_1(key);
        Integer address_2 = this.hasFunc_2(key);

        if (this.hashTable[address_1] == null) {
            this.hashTable[address_1] = new Bucket(key, value);
            this.hashTable[address_1].size++;
            System.out.println("첫 번째 해시함수가 비어있는 경우, " + address_1 + "번째 index에 저장");
            return 1;
        } else {
            if (this.hashTable[address_2] == null) {
                this.hashTable[address_2] = new Bucket(key, value);
                this.hashTable[address_2].size++;
                System.out.println("두 번째 해시함수가 비어있는 경우, " + address_2 + "번째 index에 저장");
                return 2;
            } else {
                System.out.println("비교가 필요한 경우");
                if (this.hashTable[address_1].size <= this.hashTable[address_2].size) {
                    System.out.println("hashFunc_1 거쳐 저장, " + address_1 + "번째 index에 속한 linkedList에 저장");
                    Bucket outputBucket = this.hashTable[address_1];
                    Bucket findBucket = this.hashTable[address_1];
                    Bucket preBucket = this.hashTable[address_1];
                    while (findBucket != null) {
                        if (findBucket.key == key) {
                            findBucket.value = value;
                            return 3;
                        } else
                            preBucket = findBucket;
                        findBucket = findBucket.next;
                    }
                    findBucket = new Bucket(key, value);
                    preBucket.next = findBucket;
                    while (outputBucket.next != null) {
                        System.out.print(outputBucket.value + " ");
                        outputBucket = outputBucket.next;
                    }
                    this.hashTable[address_1].size++;
                    return 4;
                } else {
                    System.out.println("hashFunc_2 거쳐 저장, " + address_2 + "번째 index에 속한 linkedList에 저장");
                    Bucket outputBucket = this.hashTable[address_2];
                    Bucket findBucket = this.hashTable[address_2];
                    Bucket preBucket = this.hashTable[address_2];
                    while (findBucket != null) {
                        if (findBucket.key == key) {
                            findBucket.value = value;
                            return 3;
                        } else
                            preBucket = findBucket;
                        findBucket = findBucket.next;
                    }
                    findBucket = new Bucket(key, value);
                    preBucket.next = findBucket;
                    while (outputBucket.next != null) {
                        System.out.print(outputBucket.value + " ");
                        outputBucket = outputBucket.next;
                    }
                    this.hashTable[address_2].size++;
                    return 5;
                }
            }
        }
    }

    public int getData(String key) {
        int index = hasFunc_1(key);
        Bucket findingBucket = hashTable[index];
        while (findingBucket != null) {
            if (findingBucket.key.equals(key)) {
                return findingBucket.value;
            }
            findingBucket = findingBucket.next;
        }
        index = hasFunc_2(key);
        findingBucket = hashTable[index];
        while (findingBucket != null) {
            if (findingBucket.key.equals(key)) {
                return findingBucket.value;
            }
            findingBucket = findingBucket.next;
        }
        return -1;
    }

}
