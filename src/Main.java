import java.util.Scanner;

public class Main {

//    import  java.util.Scanner;
    public static void main(String[] args) {                  // [5] main 메서드 실행 시작
        //  Article 객체가 생성될 때마다 생성자 호출 → id 출력
//        System.out.println(new Article().id); // 1
//        System.out.println(new Article().id); // 2
//        System.out.println(new Article().id); // 3
//        System.out.println(new Article().id); // 4
//        System.out.println(new Article().id); // 5
//        System.out.println(new Article().id); // 6
//        System.out.println(new Article().id); // 7
//        System.out.println(new Article().id); // 8
//        System.out.println(new Article().id); // 9
//        System.out.println(new Article().id); // 10
        // Article 객체를 배열에 담기 위해 10칸짜리 배열 생성, 초기값은 모두 null

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("배열 수 입력");
//        int i = scanner.nextInt();


        Article[] articles = new Article[10];

        System.out.println("-----------------");
        System.out.println("일반 for 문");

        // [7] 일반 for문: 배열의 각 칸에 Article 객체 생성 + ID 출력
        for (int i = 0; i < articles.length; i++) {
            articles[i] = new Article();                  // [8] Article 생성자 호출
            System.out.println(articles[i].id);          // [11] 생성된 객체의 ID 출력
        }

        System.out.println("------------------");
        System.out.println("향상된 for 문으로");

        // [12] 향상된 for문: 배열 안의 각 Article 객체 순회하며 ID 출력
        for (Article art : articles) {
            System.out.println(art.id);              // [13] 각 객체의 ID 출력
        }
    }
}

class Article {
    // [1] static 변수 → 모든 Article 객체가 공유하는 ID 관리용
    static int lastId;

    // [2] 인스턴스 변수 → 각 객체별로 고유 ID 저장
    int id;

    // [3] static 초기화 블록 → 클래스 로딩 시 1번 실행
    static {
        lastId = 0;   // [4] 초기 lastId 세팅
    }

    // [8] 기본 생성자 호출되는 시점: new Article() 실행될 때마다
    Article() {
        this(lastId + 1);  // [9] 다른 생성자 Article(int id) 호출, id 값 세팅
        lastId++;          // [10] lastId 증가 → 다음 객체의 ID를 위해 준비
    }

    // [9] Article(int id) 생성자
    Article(int id) {
        this.id = id;      // [10] 인스턴스 id 값 저장
    }
}
