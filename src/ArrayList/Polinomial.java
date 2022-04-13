package ArrayList;

import java.util.Arrays;
import java.util.Scanner;

class Polynomial {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String ax = scanner.next();
//        "4x^3+3x^2+5x"; // ax 식 가져옴
        String bx = scanner.next();
//        "3x^4+x^3+2x+1"; // bx 식 가져옴

        ax = ax.replace("x^", " ");    // 'x^' 부분 공백으로 치환
        ax = ax.replace("x", " 1");    // x만 있는 1차항 1로 계수 만듬
        ax = ax.replace("+", " ");     // '+' 부분 공백으로 치환
        ax = ax.replace("-", " -");    // '-' 부분 ' -'으로 치환
        ax = ax.replace("  ", " 1 ");   // 계수가 1일 부분 1로 변환
        ax = ax.trim();

        bx = bx.replace("x^", " ");    // 'x^' 부분 공백으로 치환
        bx = bx.replace("x", " 1");    // 'x'만 있는 1차항 1로 계수 만듬
        bx = bx.replace("+", " ");     // '+' 부분 공백으로 치환
        bx = bx.replace("-", " -");    // '-' 부분 ' -'으로 치환
        bx = bx.replace("  ", " 1 ");  // 계수가 1일 부분 1로 변환
        bx = bx.trim();

//        System.out.println(ax);  짝수 번째는 차수, 홀수 번째는 바로 뒤에 차수의 계수, 총 개수가 홀 수개일 경우 마지막 수는 상수항
//        // 4 3 3 2 5 1
//        System.out.println(bx);
//        // 3 4 1 3 2 1 1

        String[] temp_ax = ax.split(" ");  // 문자열인 것을 배열로 쪼갬
        String[] temp_bx = bx.split(" ");  // 문자열인 것을 배열로 쪼갬

        int [][] cal_array;    // 두 다항식 최고 차수의 크기만큼 열 크기를 넓힌 matrix 생성, 윗 줄엔 먼저 받은 거 밑에 줄엔 늦게 받은 거
        if (Integer.parseInt(temp_ax[1]) >= Integer.parseInt(temp_bx[1])){
            cal_array = new int [2][Integer.parseInt(temp_ax[1]) + 1];
        }else {
            cal_array = new int [2][Integer.parseInt(temp_bx[1]) + 1];
        }

        if (temp_ax.length % 2 == 0){    // 상수항이 없는 경우의 ax 배열을 cal_array의 첫 번째 줄에 채워넣기
            for (int i = 1; i < temp_ax.length; i+=2){
                cal_array[0][Integer.parseInt(temp_ax[i])] = Integer.parseInt(temp_ax[i-1]);
            }
        }else {    // 상수항이 있는 경우의 ax 배열을 cal_array의 첫 번째 줄에 채워넣기
            for (int i = 1; i < temp_ax.length - 1; i+=2){
                cal_array[0][Integer.parseInt(temp_ax[i])] = Integer.parseInt(temp_ax[i-1]);
            }
            cal_array[0][0] = Integer.parseInt(temp_ax[temp_ax.length-1]);
        }

        if (temp_bx.length % 2 == 0){   // 상수항이 없는 경우의 bx 배열을 cal_array의 첫 번째 줄에 채워넣기
            for (int i = 1; i < temp_bx.length; i+=2){
                cal_array[1][Integer.parseInt(temp_bx[i])] = Integer.parseInt(temp_bx[i-1]);
            }
        }else {        // 상수항이 있는 경우의 bx 배열을 cal_array의 첫 번째 줄에 채워넣기
            for (int i = 1; i < temp_bx.length - 1; i+=2){
                cal_array[1][Integer.parseInt(temp_bx[i])] = Integer.parseInt(temp_bx[i-1]);
            }
            cal_array[1][0] = Integer.parseInt(temp_bx[temp_bx.length-1]);
        }

//        System.out.println(Arrays.deepToString(cal_array));   // 배열이 제대로 다항식의 차수 별로 계수를 받았는지 확인
//        // [[0, 5, 3, 4, 0], [1, 2, 0, 1, 3]]


        int length;   // 확정된 가로 최대 길이 구하고
        if(cal_array[0].length >= cal_array[1].length){
            length = cal_array[0].length;
        }else {
            length = cal_array[1].length;
        }
        int [] add = new int[length];
        for (int i = 0; i < add.length; i ++){     // 구한 길이만큼을 새 배열에 넣은 다음 ax와 bx의 값을 더한 것을 차수별로 넣어줌
            add[i] = cal_array[0][i] + cal_array[1][i];
        }
//        for (int i = 0; i < add.length; i ++){
//            System.out.print(add[i] + " ");
//            System.out.println("");
//            // 1 7 3 5 3(계수 변경 부분 확인)
//        }

        for(int i = 0; i < add.length; i++){     // 차수별 계수의 크기가 나온 것을 출력
            switch (i){
                case 0:
                    System.out.print(add[i]);
                    break;
                case 1:
                    System.out.print("+"+add[i]+"x");
                    break;
                default:
                    System.out.print("+"+add[i]+"x^"+i);
            }
        }


    }
}
