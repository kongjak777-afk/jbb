package com.woori.BAM;

import java.util.ArrayList;   // ArrayList 사용을 위해 임포트
import java.util.List;        // List 인터페이스 임포트
import java.util.Scanner;     // 키보드 입력받는 Scanner 임포트

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 == ");
        Scanner scanner = new Scanner(System.in);   // 키보드 입력을 받는 scanner 객체 생성
        int id = 1;                                  // 글 번호(1부터 시작). 글 생성 때마다 증가
        List<Article> articles = new ArrayList<>();  // Article 객체들을 담을 리스트 생성

        while (true) {                               // 무한 반복(명령어를 계속 받기 위함)
            System.out.print("cmd) ");
            String c = scanner.nextLine().trim();    // 입력받은 명령어 문자열, 앞뒤 공백 제거
            System.out.println("명렁어) " + c);       // 입력한 명령어 출력

            if (c.equals("exit")) {                  // exit 입력하면
                System.out.println("== 프로그램 종료 ==");
                break;                               // 반복문 종료 → 프로그램 끝

            } else if (c.equals("article list")) {   // 게시글 목록 보기
                if (articles.size() == 0) {          // 리스트가 비어있으면
                    System.out.println("게시글이 없습니다.");
                } else {
                    System.out.println("번호  |  제목");

                    for (int i = 0; i < articles.size(); i++) { // 리스트 크기만큼 반복
                        Article article = articles.get(i);       // i번째 글 가져오기

                        System.out.println(article.id + "        " + article.title);
                        // 글 번호와 제목 출력
                    }
                }

            } else if (c.equals("")) {               // 공백(아무것도 안침)
                System.out.println("명령어를 입력해주세요");

            } else if (c.equals("article write")) {  // 글 작성 명령어
                System.out.print("제목 : ");
                String title = scanner.nextLine();   // 제목 입력

                System.out.print("내용 : ");
                String sub = scanner.nextLine();     // 내용 입력

                System.out.println(id + "번 글이 생성되었습니다.");

                Article article = new Article();     // Article 객체 생성
                article.id = id;                     // 글 번호 넣기
                article.title = title;               // 제목 넣기
                article.sub = sub;                   // 내용 넣기

                articles.add(article);               // 리스트에 글 추가

                id = id + 1;                         // 다음 글 번호 증가

            } else {
                System.out.println("존재하지 않는 명령어 입니다.");
                // 위의 명령어들과 일치하지 않으면 실행됨
            }
        }
    }
}

class Article {
    public Object id;     // 글 번호 (int로 해도 됨)
    public String title;  // 글 제목
    public String sub;    // 글 내용
}
