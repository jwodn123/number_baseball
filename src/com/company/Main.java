package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] comNum = new int[3];

        // 랜덤한 수 만들어 각 자리에 담는다
        for (int i = 0; i < comNum.length; i++) {
            comNum[i] = random.nextInt(9) + 1; //한 자리의 랜덤한 수 담음
            // 숫자 중복 확인
            for (int j = 0; j < i; j++) {
                if (comNum[i] == comNum[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println(comNum[0] + "," + comNum[1] + "," + comNum[2]);

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int chance = 0;

        while(true) {
            chance++;
            System.out.print(chance + "번째 시도 : ");
            String input = sc.nextLine();
            int[] userNum = new int[3];

            // 문자열인 사용자의 입력을 userNum이라는 정수 배열로 변환
            for (int i = 0; i < input.length(); i++) {
                userNum[i] = Character.getNumericValue(input.charAt(i)); //getNumericValue() 메소드를 사용하면 숫자로 된 문자형 숫자형태 그대로 반환해준다
            }

            // 컴퓨터와 사용자 입력 값 비교
            int Strike = 0;
            int Ball = 0;

            for (int i = 0; i < userNum.length; i++) {
                if (userNum[i] == comNum[i]) {
                    Strike++;
                } else {
                    for (int j = 0; j < comNum.length; j++) {
                        if (userNum[i] == comNum[j]) {
                            Ball++;
                        }
                    }
                }
            }

            if(Strike == 3) {
                System.out.println(chance + "번만에 맞히셨습니다.");
                break;
            } else if (Strike == 0 && Ball == 0) {
                System.out.println("0B0S");
            } else {
                System.out.println(Strike + "S" + Ball + "B");
            }
        }
        System.out.println("게임을 종료합니다.");

    }
}
