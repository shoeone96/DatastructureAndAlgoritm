package Stack;

import java.util.Arrays;
import java.util.Scanner;

/*
중위표현식 -> 후위표현식으로 바꾸는 과정
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        // 후위 표현식을 String으로 받는다
        Scanner scanner = new Scanner(System.in);
        System.out.println("식을 입력하시오");
        String input = scanner.next();
        // 받은 표현식을 문자 배열에 넣는다
        char[] expression = input.toCharArray();
//        System.out.println(Arrays.toString(expression));
        // 최종 후위표현식 완성물을 보여줄 String 선언, 연산자를 담을 stack 객체 생성
        String postfix = "";
        stack operator = new stack();
        // 가져오는 숫자, 연산자에 대해 처리해줄 for 문 작성
        for (int i = 0; i < expression.length; i++) {
            // 연산자 차례인 경우
            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/') {
                // 첫 연산자는 그냥 담는다
                if (operator.size() == 0) {
                    operator.push(expression[i]);
                    System.out.println(Arrays.toString(operator.getStack()));
                } else {
                    // 첫 연산자가 아닌 경우 자신의 우선순위보다 낮은 연산자가 스택 top에 올 때까지 pop하여 출력하고 읽은 연산자를 push
                    while (priority(expression[i]) <= priority((char) operator.peek())) {
                        if (operator.size() == 0) break;
//                        System.out.println(operator.pop());
                        postfix = postfix + operator.pop();
                    }
                    operator.push(expression[i]);
                    // operator stack에 연산자가 연산자가 빠져나가거나 추가되는 상황이 발생했으므로 이를 1번으로 표현한 뒤 operator를 출력
                    System.out.println(Arrays.toString(operator.getStack()) + " 1");
                }
                // '('괄호가 들어와 추가하는 상황, 추가한 후 이를 2번으로 출력
            } else if (expression[i] == '(') {
                operator.push(expression[i]);
                System.out.println(Arrays.toString(operator.getStack()) + " 2");
                // ')'닫는 괄호가 나올 시 다시 여는 괄호가 나올 때까지 pop하는 과정을 거친 후 '('를 pop한다. 이 과정 이후 stack의 상태를 3번으로 출력
            } else if (expression[i] == ')') {
                while (!operator.peek().equals('(')) {
//                    System.out.println(operator.pop());
                    postfix = postfix + operator.pop();
                }
                operator.pop();
                System.out.println(Arrays.toString(operator.getStack()) + " 3");
            } else {
                // 숫자가 들어온 경우 postfix에 더해줌
                postfix = postfix + (expression[i]);
            }
        }
        // 최종적으로 남아있는 operator 원소들을 4번으로 출력
        while (!operator.isEmpty()) {
            postfix = postfix + (char) operator.pop();
            System.out.println(Arrays.toString(operator.getStack()) + " 4");
        }
        // 최종적으로 완성된 postfix 출력
        System.out.println("후위표기식 변형: " + postfix);
        scanner.close();
    }

    public static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else return 0;
    }
}
