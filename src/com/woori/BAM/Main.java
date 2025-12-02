package com.woori.BAM;

import java.time.LocalDateTime; // 날짜 시간 사용을 위해서 임포트
import java.util.ArrayList;   // ArrayList 사용을 위해 임포트
import java.util.List;        // List 인터페이스 임포트
import java.util.Scanner;     // 키보드 입력받는 Scanner 임포트

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 == "); // [1] 프로그램 시작 메시지 출력
        Scanner scanner = new Scanner(System.in);   // [2] Scanner 객체 생성: 키보드 입력 받기
        int id = 1;                                  // [3] 글 번호 초기화 (1부터 시작)
        List<Article> articles = new ArrayList<>();  // [4] 게시글을 담을 리스트 생성

        while (true) {                               // [5] 무한 루프 시작: 명령어 입력 계속 받기
            System.out.print("cmd) ");
            String cmd = scanner.nextLine().trim();    // [6] 명령어 입력, 공백 제거
//            System.out.println("명렁어) " + cmd);       // [7] 입력한 명령어 출력

            if (cmd.equals("exit")) {                  // [8] exit 입력 시 프로그램 종료
                System.out.println("== 프로그램 종료 ==");
                break;                               // [9] 반복문 탈출 → 프로그램 종료

            } else if (cmd.equals("article list")) {   // [10] 게시글 목록 보기 명령어
                if (articles.size() == 0) {          // [10.1] 게시글 없으면 안내
                    System.out.println("게시글이 없습니다.");
                } else {
                    System.out.println("번호  |  제목");
                    for (int i = articles.size()-1; i >= 0; i--) { // [10.2] 리스트 크기만큼 반복 // 역순으로
                        Article article = articles.get(i);       // [10.3] i번째 글 가져오기
                        System.out.println(article.id + "        " + article.title); // [10.4] 번호와 제목 출력
                    }
                }

            } else if (cmd.equals("")) {               // [11] 공백 입력 시 안내
                System.out.println("명령어를 입력해주세요");

            } else if (cmd.equals("article write")) {  // [12] 글 작성 명령어
                System.out.print("제목 : ");
                String title = scanner.nextLine();   // [12.1] 제목 입력

                System.out.print("내용 : ");
                String sub = scanner.nextLine();     // [12.2] 내용 입력

                System.out.println(id + "번 글이 생성되었습니다."); // [12.3] 글 생성 안내

//                Article article = new Article();     // [12.4] Article 객체 생성
                Article article = new Article(id, title, sub);     // [12.4] Article 객체 생성
//                article.id = id;                     // [12.5] 글 번호 할당
//                article.title = title;               // [12.6] 제목 할당
//                article.sub = sub;                   // [12.7] 내용 할당

                LocalDateTime nowDate = LocalDateTime.now();  // [12.8] 현재 날짜/시간 생성
                article.nowDate = nowDate;              // [12.9] Article 객체에 날짜/시간 저장

                articles.add(article);               // [12.10] 리스트에 글 추가

                id = id + 1;                         // [12.11] 다음 글 번호 증가

            } else if (cmd.startsWith("article detail")) { // [13] article detail로 시작하는 명령어 처리
                String[] cmdbits = cmd.split(" ");   // [13.1] 공백 기준으로 문자열 나누기
                Article foundArticle = null;           // [13.2] 찾은 글 객체 초기화
                int ids = Integer.parseInt(cmdbits[2]); // [13.3] 세 번째 요소를 정수로 변환 (조회할 글 번호)

                for (Article a : articles) {          // [13.4] 리스트에서 글 찾기
                    if (a.id == ids) {
                        foundArticle = a;           // [13.5] 글 찾으면 저장
                        break;                     // [13.6] for문 종료
                    }
                }

                if (foundArticle == null) {           // [13.7] 글이 없으면 안내
                    System.out.println(ids + "번 게시글이 존재하지 않습니다");
                    continue; // [13.8] while 루프 처음으로 돌아감
                }

                // [13.9] 글 상세 정보 출력
                System.out.println("번호 :" + foundArticle.id);
                System.out.println("날짜 :" + foundArticle.nowDate);
                System.out.println("제목 :" + foundArticle.title);
                System.out.println("내용 :" + foundArticle.sub);

            } else {
                System.out.println("존재하지 않는 명령어 입니다."); // [14] 잘못된 명령어 처리
            }
        }
    }
}

class Article {
    public int id;          // [15] 글 번호
    public String title;    // [16] 글 제목
    public String sub;      // [17] 글 내용
    public Object nowDate;  // [18] 작성 날짜/시간

    public Article(int id, String title, String sub) {

        this.id = id;                     // [12.5] 글 번호 할당
        this.title = title;               // [12.6] 제목 할당
        this.sub = sub;                   // [12.7] 내용 할당
    }
}