package Searching;
import java.util.Scanner;
/*
하노이 탑 문제
원판을 가장 끝에 옮기기 위해
최초의 n = 3일때의 알고리즘(base case)을 이용해 재귀함수를 호출하여 이용
 */
public class Hanoi {
    public static void main(String[] args) {
        System.out.print("움직이실 원판의 개수를 입력하시오: >>>> ");
        Scanner scanner = new Scanner(System.in);
        int circle; //원판 갯수
        circle = scanner.nextInt();
        // 함수 처음 호출
        hanoi(1, 2, 3, circle);
    }

    public static void hanoi(int start, int middle, int destination, int circle) {//start -> destination 로 원판 circle(가장 큰 원판)이 이동
        if (circle == 0) return;
        // 원판 circle-1은 from -> m으로 이동(n이 base case로 갈 때 까지 지속 되는 부분)
        hanoi(start, destination, middle, circle - 1);
        // 원판 circle이 start -> destination으로 이동
        // 원판의 숫자가 커지면 더 큰 원판을 의미
        System.out.println("움직이는 원판: " + circle + ", 시작지점: " + start + " -> 도착지점: " + destination);
        // 원판 circle-1이 middle -> destination로 이동
        hanoi(middle, start, destination, circle - 1);
    }
}


