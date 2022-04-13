package Stack;

import java.util.Arrays;
import java.util.Scanner;

/*
 첫 오류 발생
 처음 계산 시 char를 inteager에 넣으면서 아스킷 코드 숫자로 들어가는 문제 발생
 숫자 넣어줄 때 char -> Inteager 변환과정을 넣음
 */

/*
 후위표현식의 계산
 */

public class CalculatingByPostfix {
    public static void main(String [] args){
        // scanner로 후위표현식을 받음
        Scanner scanner = new Scanner(System.in);
        System.out.println("후위표기식을 입력하시오: ");
        String postfix = scanner.next();
        // 받은 후위 표현식을 문자 배열로 변환
        char [] calculatingPostfix = postfix.toCharArray();
        // 연산할 숫자를 받을 inteager stack 인스턴스 생성
        stack<Integer> calculatingNumber = new stack();
        // for문을 돌며 계산
        for (int i = 0; i < calculatingPostfix.length; i++){
            // 연산식이 들어온 경우 숫자를 넣어놓은 stack에서 하나씩 숫자를 뽑아 처음 뽑은 숫자를 secondNum, 두 번째 뽑은 숫자를 firstNum, pop하는 경우 숫자를 담아 저장할 temp를 선언
            if (calculatingPostfix[i] == '+' || calculatingPostfix[i] == '-' || calculatingPostfix[i] == '*' || calculatingPostfix[i] == '/'){
                int secondNum = calculatingNumber.pop();
                int firstNum = calculatingNumber.pop();
                int temp = 0;
//                System.out.println("firstNum: " + firstNum + " secondNum: " + secondNum);
                // 각각 덧셈, 뺄셈, 곱셈, 나눗셈의 경우를 switch case로 작성
                switch (calculatingPostfix[i]){
                    // 덧셈의 경우 firstNum과 secondNum을 더하고 계산한 결과를 넣은 stack을 출력
                    case '+':
                        temp = firstNum + secondNum;
//                        System.out.println("firstNum: " + firstNum + " secondNum: " + secondNum + " temp: " + temp);
                        calculatingNumber.push(temp);
                        System.out.println(Arrays.toString(calculatingNumber.getStack()) + " 덧셈 계산");
                        break;
                    // 뺄셈의 경우 firstNum과 secondNum을 빼고 계산한 결과를 넣은 stack을 출력
                    case '-':
                        temp = firstNum - secondNum;
//                        System.out.println("firstNum: " + firstNum + " secondNum: " + secondNum + " temp: " + temp);
                        calculatingNumber.push(temp);
                        System.out.println(Arrays.toString(calculatingNumber.getStack()) + " 뺄셈 계산");
                        break;
                    // 곱셈의 경우 firstNum과 secondNum을 곱하고 계산한 결과를 넣은 stack을 출력
                    case '*':
                        temp = firstNum * secondNum;
//                        System.out.println("firstNum: " + firstNum + " secondNum: " + secondNum + " temp: " + temp);
                        calculatingNumber.push(temp);
                        System.out.println(Arrays.toString(calculatingNumber.getStack()) + " 곱셈 계산");
                        break;
                    // 나눗셈의 경우 firstNum과 secondNum을 나누고 계산한 결과를 넣은 stack을 출력
                    case '/':
                        temp = firstNum / secondNum;
                        calculatingNumber.push(temp);
//                        System.out.println("firstNum: " + firstNum + " secondNum: " + secondNum + " temp: " + temp);
                        System.out.println(Arrays.toString(calculatingNumber.getStack()) + " 나눗셈 계산");
                        break;
                }
            }else {
                // 숫자 차례인 경우 숫자 stack에 넣어줌
                // 첫 번째 오류 해결: char를 int로 바꿔주는 과정 추가
                calculatingNumber.push(calculatingPostfix[i] - '0');
                System.out.println(Arrays.toString(calculatingNumber.getStack()) + " 숫자 추가");

            }
        }
        System.out.println("후위표기법 계산 결과: " + calculatingNumber.pop());
        scanner.close();
    }
}
