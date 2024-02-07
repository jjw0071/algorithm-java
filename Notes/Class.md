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
class형 변수를 사용할 때는 먼저 class형 변수를 만들고, 그 실체인 class 인스턴스를 생성해야 함. <br>
그리고 배열과 같은 방식으로 연결해야 함.
```java
XYZ a;  //XYZ형의 class형 변수 a 선언
a = new XYZ();  //XYZ형의 class 인스턴스를 생성하고 참조하는 곳을 대입
XYZ a = new XYZ() //XYZ형의 class형 변수의 선언, 인스턴스 생성, 연결을 한번에 수행
```
class 내부의 필드에 접근 하려면 멤버 접근 연산자(.)를 사용
{ex) a.x, a.y, a.z}

## class 본체와 멤버
class 본체에서 선언할 수 있는 것
- 멤버(필드, 메서드, 중첩(nested) class, 중첩 인터페이스)
- class 초기화, 인스턴스 초기화
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
public을 붙여 class를 선언 시 다른 패키지에서 사용할 수 있는 공개 class(public class)가 됨
## 파이널 class
final을 붙여 선언하면 하위 class를 가질 수 없는 class가 됨
## 파생 class
class A를 직접 상위 class로 하려면 선언시 extends A를 추가해야 함<br>
이 때 선언한 class는 class A의 직접 하위 class가 됨<br>
class 선언시 extends가 없는 class의 경우 직접 상위 class는 Object class가 됨
```java
class C extends A {
    //
}
```
## 인터페이스 구현
인터페이스 X를 구현하라면 class 선언에 implements X를 추가해야 함
```java
class Y implements X{
    //
}
```
## 추상 class
abstract를 붙여 class를 선언시 추상 메서드를 가질 수 있는 추상 class 생성됨.<br>
추상 class는 불완전한 class 이므로 인스턴스를 만들 수 없음(실체는 하위 class에서 정의)
## 중첩 class
class 또는 인터페이스 안에 선언한 class
- 멤버 class : 선언이 다른 class 또는 인터페이스 선언에 의해 직접 둘러싸인 class
- 내부 class : 명시적, 암묵적으로 정적이라고 선언하지 않은 중첩 class로, 정적 초기화나 멤버 인터페이스 선언 할 수 없음
- 지역 class : 이름이 주어진 중첩 class인 내부 class로, 어떤 class의 멤버도 될 수 없음.