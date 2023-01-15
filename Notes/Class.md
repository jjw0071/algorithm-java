# Class란?
## 정의
서로 다른 여러 데이터 형을 자유로이 조합하여 만들 수 있는 자료구조
## 선언
```java
class XYZ {
    int x; //x는 int형 필드
    long y; //y는 long형 필드
    double z; //z는 double형 필드
}
```
앞의 XYZ class는 3개의 데이터 요소를 가짐 <br>
데이터 요소를 필드(field)라고 함<br>
클래스형 변수를 사용할 때는 먼저 클래스형 변수를 만들고, 그 실체인 클래스 인스턴스를 생성해야 함. <br>
그리고 배열과 같은 방식으로 연결해야 함.
```java
XYZ a;  //XYZ형의 클래스형 변수 a 선언
a = new XYZ();  //XYZ형의 클래스 인스턴스를 생성하고 참조하는 곳을 대입
XYZ a = new XYZ() //XYZ형의 클래스형 변수의 선언, 인스턴스 생성, 연결을 한번에 수행
```
클래스 내부의 필드에 접근 하려면 멤버 접근 연산자(.)를 사용
{ex) a.x, a.y, a.z}

## class 본체와 멤버
class 본체에서 선언할 수 있는 것
- 멤버(필드, 메서드, 중첩(nested) 클래스, 중첩 인터페이스)
- 클래스 초기화, 인스턴스 초기화
- 생성자<

class의 문법 규칙과 특징
- 필드, 메서드, 생성자를 선언할 때 public, protected, private 지정 가능
- 메서드, 생성자를 다중의로 정의(오버로드) 가능
- final로 선언한 필드는 값을 한 번만 대입 가능
- 생성자는 새로 생성하는 인스턴스를 초기화 하기 위해 사용

### 간단한 class의 예
```java
class A {
    private int f1; // 비공개 필드
    protected int f2; // 한정 공개 필드
    public int f3; // 공개 필드
    
    static final int S1 = 0; //정적 상수 필드
    
    public A() {
        f1 = f2 = f3 = 0;
    }
    
    public A(int f1, int f2, int f3){ // 생성자
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }
    
    public void setF1(int f ){ //메서드 f1의 setter
        f1 = f;
    }
    
    public int getF1(){ // 메서드 f1의 getter
        return f1;
    }
}
```

## 공개 class
클래스 접근 제한자인 public을 붙여 클래스를 선언 시 다른 패키지에서 사용할 수 있는 공개 클래스(public class)가 됨

