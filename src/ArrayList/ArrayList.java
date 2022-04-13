package ArrayList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> {
    private T list[]; // 어떤 타입으로 배열을 생성할지 모르기에 초기에는 generics로 설정
    private int size; // 데이터의 사이즈를 측정할 변수 설정

    // test
    public static void main(String args[]){
//        ArrayList array = new ArrayList();
//        array.insertLast(3);
//        array.insertLast(4);
//        array.insertLast(5);
//        array.insertLast(6);
//        array.insertLast(7);
//        array.insertMiddle(3, 1);
//        for (int i = 0; i < array.size; i++){
//            System.out.print(array.list[i] + " ");
//        }
//        System.out.println("");
//        System.out.println("=========");
//        array.deleteMiddle(3);
//        for (int i = 0; i < array.size; i++){
//            System.out.print(array.list[i] + " ");
//        }
//        System.out.println("");
//        System.out.println("=========");
//        array.deleteMiddle(3);
//        for (int i = 0; i < array.size; i++){
//            System.out.print(array.list[i] + " ");
//        }
//        System.out.println("");
//        System.out.println("=========");
//        array.deleteMiddle(3);
//        for (int i = 0; i < array.size; i++){
//            System.out.print(array.list[i] + " ");
//        }
//        System.out.println("");
//        System.out.println("=========");
//        array.deleteMiddle(3);
//        for (int i = 0; i < array.size; i++){
//            System.out.print(array.list[i] + " ");
//        }
//        ArrayList a = new ArrayList();
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        a.insertLast(3);
//        System.out.println(a.list.length);
    }

    // 초기 배열 생성자
    public ArrayList(int listSize){
        this.size = 0;
        this.list = (T[]) new Object[listSize];
    }

    // 탐색
    public T read(int input){
        if(size == 0 || size < input){    // input이 실제 데이터의 사이즈보다 크거나 사이즈의 값이 없는 0인 경우의 예외처리
            try {
                throw new NoSuchElementException("input을 잘못 입력하였습니다"); // 예외를 고의로 내고 예외 내용을 넣어줍니다.
            } catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return list[input];  // 문제가 없다면 해당 인덱스의 원소를 전달
    }

    // 마지막에 삭제
    public void deleteLast(){
        if (size == 0){    // underflow가 발생하는 경우, 즉 삭제 할 내용이 없을 경우에 예외처리
            try {
                throw new NoSuchElementException("input을 잘못 입력하였습니다");
            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        list[size-1] = null;            // 마지막 데이터를 null 값으로 만들어 데이터를 삭제(index는 시작이 0이고 size는 시작이 1이라 하나 줄인 값을 삭제)
        size --;                        // 마지막 값을 삭제했으므로 사이즈도 동일하게 삭제
        if (size == list.length/4){     // 데이터의 크기가 전체 배열 길이의 1/4인 경우 배열의 길이를 1/2로 줄인 새로운 배열을 만들어 옮겨감
            list = Arrays.copyOf(list, list.length/2);
        }

    }

    // 중간에 삭제
    public void deleteMiddle(int input){
        if (size == 0 || input >= size){    // 사이즈가 0이라 삭제할 내용이 없거나 삭제하고자 하는 index가 size와 같은 경우는 deleteLast 사용하게 예외, size보다 크면 삭제할 데이터가 없기에 예외처리
            try {
                throw new NoSuchElementException("input을 잘못 입력하였습니다");
            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }else {       // 정상적으로 입력을 한 경우 해당 인덱스의 값부터 그 다음 인덱스에 위치한 값으로 덮어 삭제된 형태로 만든다.
            for (int i = input; i < size; i++){
                list[i] = list[i+1];
            }
            list[size] = null;   // 마지막 값은 데이터의 사이즈로만 추적하기에 null로 만들지 않아도 되지만 정확도를 위해 데이터가 없는 것을 null로 구현
            size --;             // 사이즈를 줄여 데이터가 삭제되었다는 것을 사이즈 크기로 확인 가능하게 만든다.
        }
        if (size == list.length/4){     // 사이즈 축소 이후 사이즈의 크기가 전체 배열 크기의 1/4인 경우 불필요한 공간을 많이 쓰기에 공간을 1/2만 사용하는 배열로 다시 만듬
            list = Arrays.copyOf(list, list.length/2);
        }
    }

    // 마지막에 삽입
    public void insertLast (T t) {
        if (size == list.length){              // 삽입 전 오버플로우가 발생하는지 확인하고 삽입 시 오버플로우가 발생할 것 같으면 사이즈가 두 배이며 내용물이 복사된 배열을 생성
            list = Arrays.copyOf(list, list.length*2);
        }
        list[size++] = t;      // size-1을 index로 해야 데이터의 마지막 값을 구할 수 있기 때문에 size에 해당하는 값에 새로운 값을 삽입하고 다음 size 크기를 늘려줘야 한다.
    }

    // 중간에 삽입
    public void insertMiddle(T t, int input){
        if (this.size == this.list.length){   // 삽입 전 오버플로우가 발생하는지 확인하고 삽입 시 오버플로우가 발생할 것 같으면 사이즈가 두 배이며 내용물이 복사된 배열을 생성
            this.list = Arrays.copyOf(this.list, this.list.length*2);
        }
        for (int i = size-1; i>= input; i--){  // 제일 마지막 데이터부터 시작하여 index를 한 칸씩 크게 옮겨간다
            list[i+1] = list[i];
        }
        size ++;               // 데이터의 끝이 하나 커진만큼 사이즈도 하나 키운다
        list[input] = t;       // input에 삽입하고싶은 index를 넣는다.
    }
}
