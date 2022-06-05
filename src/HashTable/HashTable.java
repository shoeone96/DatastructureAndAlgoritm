package HashTable;

/*
key를 지정하고 본인이 정의한 hash function에 따라 부합하는 hash table을 제공
 */
public class HashTable {
    // Slot 이라는 주소값을 담을 객체 배열을 생성하고 이렇게 생성된 테이블을 HashTable로 명명
    public Slot[] hashTable;

    // 처음 HashTable을 구현할 때 그 사이즈를 확인하여 만든다
    public HashTable(Integer size){
        this.hashTable = new Slot[size];
    }

    // 저장된 객체의 주소를 모아놓은 Slot 객체를 생성, 객체 주소를 담지만 여기서는 String 을 담는다
    public class Slot{
        String value;
        Slot(String value){
            this.value = value;
        }
    }

    /*
     hash function, 키 값을 집어넣었을 때 그 키 값에 해당하는 객체의 위치를 돌려주는 함수
     이 경우 slot 의 배열인 hashtable 에 값이 저장되었기 때문에 배열의 인덱스를 반환하는 함수
     이번 함수의 경우 맨 앞 글자의 아스킷 코드를 hash table 의 길이만큼 나눈 나머지를 주소로 저장하는 방식
    */
    public int hasFunc(String key){
        return (int)(key.charAt(0))%this.hashTable.length;
    }

    /*
     데이터 저장
     실제 key 를 바탕으로 저장을 실행하게 되면 저장되는 위치를 hash function 을 통해 설정하고
     그렇게 나온 배열 index 의 위치에 저장하는 방식
     이미 값이 있다면 덮어쓰는 방식으로 진행
     */
    public boolean saveData(String key, String value){
        Integer address = this.hasFunc(key);
        if(this.hashTable[address]!= null){
            this.hashTable[address].value = value;
        }else this.hashTable[address] = new Slot(value);
        return true;
    }

    /*
     데이터 탐색
     key 값을 통해 저장한 방식 대로 객체가 배열된 주소를 찾고
     그 값을 return 하는 과정
     */
    public String getData(String key){
        int address = this.hasFunc(key);
        if (this.hashTable[address]!=null){
            return hashTable[address].value;
        }else return null;
    }

    /*
    - 장점
      - 데이터 저장/읽기 속도가 빠르다. (검색 속도가 빠르다.)
      - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉬움
    - 단점
      - 일반적으로 저장공간이 좀더 많이 필요하다.
  - **여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요함**
    - 주요 용도
      - 검색이 많이 필요한 경우
      - 저장, 삭제, 읽기가 빈번한 경우
      - 캐쉬 구현시 (중복 확인이 쉽기 때문)
     */
}
