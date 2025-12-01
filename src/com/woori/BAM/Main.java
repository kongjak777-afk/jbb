package com.woori.BAM;

import java.util.Scanner;                               // 스캐너 클래스를 임포트

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 == ");
        Scanner scanner = new Scanner(System.in);       // Scanner 타입의 scanner 를 생성
        System.out.print("cmd) ");
        String s = scanner.nextLine();                         // s를 스캐너로 문자열 입력 받아 초기화
        System.out.println("명렁어) " + s);
        System.out.println("== 프로그램 종료 ==");
    }
}
