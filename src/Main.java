public class Main {
    public static void main(String[] args) {                  // [5] main 메서드 실행 시작

        // [6] Article 객체가 생성될 때마다 생성자 호출 → id 출력
        System.out.println(new Article().id); // 1
        System.out.println(new Article().id); // 2
        System.out.println(new Article().id); // 3
        System.out.println(new Article().id); // 4
        System.out.println(new Article().id); // 5
        System.out.println(new Article().id); // 6
        System.out.println(new Article().id); // 7
        System.out.println(new Article().id); // 8
        System.out.println(new Article().id); // 9
        System.out.println(new Article().id); // 10
    }
}

class Article {
    // [1] static 변수 → Article 클래스를 프로그램이 처음 사용할 때 단 1개만 생성됨
    static int lastId;

    // [2] 인스턴스 변수 → Article 객체가 만들어질 때마다 각각 따로 생성됨
    int id;

    // [3] static 초기화 블록 → Article 클래스가 로딩될 때 단 1번 실행됨
    static {
        lastId = 0;   // [4] lastId 초기 세팅(0)
    }

    // [7] 기본 생성자 호출되는 시점: new Article() 실행될 때마다
    Article() {
        this(lastId + 1);  // [8] 다른 생성자 Article(int id) 호출하면서 id 값을 lastId+1로 전달
        lastId++;          // [11] 객체 생성 완료 후 lastId 증가 → 다음 객체는 더 큰 번호 사용
    }

    // [9] Article(int id) 생성자
    Article(int id){
        this.id = id;      // [10] 인스턴스 id 값 세팅
    }
}
