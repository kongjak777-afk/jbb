package com.woori.BAM;

import java.util.Scanner;                               // 스캐너 클래스를 임포트

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 == ");
        Scanner scanner = new Scanner(System.in);        // Scanner 타입의 scanner 를 생성

        while (true) {                                   // 와일문으로 무한루프로 캡슐화
            System.out.print("cmd) ");
            String s = scanner.nextLine();                         // s를 스캐너로 문자열 입력 받아 초기화
            System.out.println("명렁어) " + s);

            if (s.equals("exit")) {                        // 와일 무한루프 탈출 기능 if문으로 넣음
                System.out.println("== 프로그램 종료 ==");  // exit 입력하면 이 문구 출력되며
                break;                                    // 루프 빠져나감
            }

        }
    }
}
