# 알고리즘 공부 <br><hr/>
## 배열<br>
1. 배열의 index는 0부터 시작

## 유용할 만한 것
1. for문에 쓰인 변수를 다시 쓰고 싶으면 for문 밖에 선언하자.
2. 마지막 반복을 실행할 조건을 확실히 알면 앞에 반복문에서 조건판단 횟수를 줄일수 있다.
<br>(Chp01의 printstar2가 printstar1보다 효율적임)
3. 확장 for문은 배열안의 모든 요소를 한 개씩 스캔할 때 사용가능하다.
>```java
>double[] a = {1.0,2.0,3.0};
>double sum = 0;
>for(double i : a)
>   sum += i;
>```
>이런 경우 i는 a 배열 내의 각각의 요소를 순차적으로 의미한다.<br>
>본문 내에서 i는 선택된 요소를 의미한다.<br>
>위 for문은
>```java
>for(int i;i<a.length;i++){
>    sum += a[i];
>```
>과 같은 의미이다. for문에서 i<=a.length가 되지 않게 주의해야 한다.