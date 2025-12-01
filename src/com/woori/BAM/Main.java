package com.woori.BAM;

import java.util.Scanner;                               // 스캐너 클래스를 임포트

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 == ");
        Scanner scanner = new Scanner(System.in);        // Scanner 타입의 scanner 를 생성
        int i = 1;                                       // article write 에서 "n번째 글" 을 표현하기 위한 변수 초기화를 와일문 외부에

        while (true) {                                   // 와일문으로 무한루프로 캡슐화
            System.out.print("cmd) ");
            String c = scanner.nextLine().trim();        // s를 스캐너로 문자열 입력 받아 초기화,trim() 메소드로 앞뒤 공백제거
            System.out.println("명렁어) " + c);

            if (c.equals("exit")) {                        // 와일 무한루프 탈출 기능 if문으로 넣음
                System.out.println("== 프로그램 종료 ==");  // exit 입력하면 이 문구 출력되며
                break;                                 // 루프 빠져나감

            } else if (c.equals("article list")) {
                System.out.println("게시글이 없습니다.");
            } else if (c.equals("")) {                        //  공백은 "" 이렇게 문자열 길이로 표현 null 이 아님
                System.out.println("명령어를 입력해주세요");
            } else if (c.equals("article write")) {

                System.out.print("제목 : ");
                String title = scanner.nextLine();
                System.out.print("내용 : ");
                String sub = scanner.nextLine();

                System.out.println(i + "번 글이 생성되었습니다.");        // 몇번쨰 글이 라는 표현
                i = i + 1;                                                // 증감식

            } else {
                System.out.println("존재하지 않는 명령어 입니다.");   // 그 밖의 키워드는 존재 하지 않음 else
            }

        }
    }
}
