package hello.core.singleton;

public class SingletonService {
    /*
    *   static 영역에 객체 instance 를 미리 하나만 생성해서 올려둔다.
    *   getInstance() 메세더를 호출하면 하상 같은 인스턴스 반환
    *   생성자를 private으로 막아서 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.
    * */
    private static final SingletonService instance = new SingletonService();

    // 생성자를 private 으로 만들면 외부에서 생성하지 못함
    private SingletonService (){ } //

    public static  SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출 ");
    }
}
