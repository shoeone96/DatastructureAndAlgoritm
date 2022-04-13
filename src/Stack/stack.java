package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class stack<E> {
    private E [] stack;
    private int top;

    public E [] getStack(){
        return stack;
    }
    public int getTop(){
        return top;
    }
     // 생성자를 통한 스택 배열 생성
    public stack(){
        stack = (E[]) new Object[1];
        top = -1;
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty() {return (top == -1);}

    // push 새로운 객체 하나를 스택에 쌓는 방식, 단 overflow를 고려하여 사이즈가 스택 크기와 동일해지면 두 배로 늘림
    public void push(E newItem){
        if (size() == stack.length)
            resize(stack.length*2);
        stack[++top] = newItem;
    }

    // pop 제일 위에 쌓인 객체를 꺼낸 뒤 제거하는 방식, 비어있으면 예외처리를 하고, 다른 참조변수로 가장 위의 변수를 담아둔 뒤 기존의 제일 위에 것은 삭제하고 사이즈를 줄인다
    // 줄인 이후 underflow 발생 시 배열의 길이를 절반으로 줄여준다
    // 마지막으로 참조변수에 담아두었던 객체를 반환
    public E pop(){
        if (isEmpty()) throw new EmptyStackException();
        E topElement = stack[top];
        stack[top--] = null;
        if(size() >0 && size() == stack.length/4) resize(stack.length/2);
        return topElement;
    };

    // peek 제일 위에 쌓인 객체가 어떤 것인지만 알려주는 방식
    // 비어있는 객체면 예외처리를 해주고
    // 그렇지 않으면 제일 위의 원소를 반환
    public E peek(){
        if (isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    // resize 오버플로우 혹은 언더플로우 발생 시 배열을 복사하고 사이즈를 바꾸는 역할을 하는 함수
    public void resize(int newSize){
        stack = Arrays.copyOf(stack, newSize);
    };
}
