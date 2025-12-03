package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int lastArticleID = 1;
    static List<Article> articles = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);


        makeTestData();


        while (true) {
            System.out.printf("cmd) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }

            if (cmd.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("게시글이 없습니다");
                    continue;
                }
                System.out.println("번호  |   제목   |  내용  |       regDate    |   조회수");
                for (int i = articles.size() - 1; i >= 0; i--) {
                    Article article = articles.get(i);
                    System.out.printf("%d    |    %s   |  %s  |   %s  |  %d\n",
                            article.id, article.title, article.body, article.regDate, article.viewCnt);
                }

            } else if (cmd.equals("article write")) {

                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String body = sc.nextLine();
                System.out.println(lastArticleID + " 번글이 생성되었습니다");

                Article article = new Article(lastArticleID, title, body, Util.getDateStr(), 0);
                articles.add(article);

                lastArticleID++;

            } else if (cmd.startsWith("article detail")) {

                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 3) {
                    System.out.println("번호를 입력해 주세요");
                    continue;
                }

                int id;
                try {
                    id = Integer.parseInt(cmdBits[2]);
                } catch (Exception e) {
                    System.out.println("정수를 입력하시길 바랍니다");
                    continue;
                }

                Article foundArticle = null;
                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue;
                }

                foundArticle.increaseViewCnt();

                System.out.println("번호 : " + foundArticle.id);
                System.out.println("날짜 : " + foundArticle.regDate);
                System.out.println("제목 : " + foundArticle.title);
                System.out.println("내용 : " + foundArticle.body);
                System.out.println("조회수 : " + foundArticle.viewCnt);

            } else if (cmd.startsWith("article modify")) {

                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 3) {
                    System.out.println("번호를 입력해 주세요");
                    continue;
                }

                int id;
                try {
                    id = Integer.parseInt(cmdBits[2]);
                } catch (Exception e) {
                    System.out.println("정수를 입력하시길 바랍니다");
                    continue;
                }

                Article foundArticle = null;
                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue;
                }

                System.out.print("수정할 제목 : ");
                String title = sc.nextLine().trim();
                System.out.print("수정할 내용 : ");
                String body = sc.nextLine().trim();

                foundArticle.title = title;
                foundArticle.body = body;

                System.out.println(id + "번 게시물이 수정되었습니다");

            } else if (cmd.startsWith("article delete")) {

                String[] cmdBits = cmd.split(" ");
                if (cmdBits.length < 3) {
                    System.out.println("번호를 입력해 주세요");
                    continue;
                }

                int id;
                try {
                    id = Integer.parseInt(cmdBits[2]);
                } catch (Exception e) {
                    System.out.println("정수를 입력하시길 바랍니다");
                    continue;
                }

                Article foundArticle = null;
                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue;
                }

                articles.remove(foundArticle);

                System.out.println(id + "번 게시물이 삭제되었습니다");

            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }
        }

        System.out.println("== 프로그램 종료 ==");
    }

    static void makeTestData() {

        for (int i = 1; i <= 500; i++) {
            String 제목 = "제목" + i;                       //자동 형변환 됨
            String 내용 = "내용" + i;
            int 뷰카운트 = i;
            int 라스트아이디 = lastArticleID++;
            String 일시 = Util.getDateStr();

//            articles.add(new Article(라스트아이디,제목,내용,일시,뷰카운트));   // 이렇게 해도 되고
            Article article = new Article(라스트아이디,제목,내용,일시,뷰카운트);  // 이렇게 해도 됨
            articles.add(article);                                           // 대신 아래 코드까지
        }


//        Article ar1 = new Article(lastArticleID++,"제목1","내용1",Util.getDateStr(),10);
//        articles.add(ar1);
//        Article ar2 = new Article(lastArticleID++,"제목2","내용2",Util.getDateStr(),20);
//        articles.add(ar2);
//        Article ar3 = new Article(lastArticleID++,"제목3","내용3",Util.getDateStr(),30);
//        articles.add(ar3);
    }

    // static 중첩 클래스(Outer 클래스에서 바로 사용 가능하게)
    static class Article {
        int id;
        String title;
        String body;
        String regDate;
        int viewCnt;

//        Article() {}

        Article(int id, String title, String body, String regDate, int viewCnt) {
            this.id = id;
            this.title = title;
            this.body = body;
            this.regDate = regDate;
            this.viewCnt = viewCnt;
        }

        void increaseViewCnt() {
            this.viewCnt++;
        }
    }
}
