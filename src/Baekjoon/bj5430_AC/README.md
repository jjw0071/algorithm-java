# AC

## 문제 이해
R이면 배열의 순서를 뒤집고, D이면 첫 번째 수를 버리게 해야 한다.  
최대 100개의 테스트 케이스가 주어지고, 그 다음 줄에 명령어, 그 다음줄에 [1,2,3] 이런 형태의 배열이 주어진다.  
먼저 명령어를 처리하고, 배열을 만드는 함수를 만들어서 실행해야 겠다.



## 문제 해결
순서를 뒤집는 걸 처리하기 위해 ArrayDeque을 사용해봐야 겠다.  
  
입력값을 명령어는 char[] command로 바꾸어 처리했고, 입력 배열 들은 [,] 을 substring으로 제거하고, 그 남은 문자열을 ,로 split하여 String[]로 바꾸었다.  
그리고 그 값들을 읽어들이면서 정수로 바꾸고 ArrayDeque에 추가했다.  
이렇게 값들을 함수로 넘겨서 실행했다. 이 함수는 boolean으로 forward를 가지고 true 면 앞에서부터, false면 뒤에서부터 deque을 처리하게 했다.  
그렇게 마지막에도 문자열로 바꿀 때도 forward를 확인해 앞에서부터인지 뒤에서부터인지 확인해 Stringbuilder로 정답을 만들고 넘겨주었다.  


## 문제 링크
https://www.acmicpc.net/problem/5430

## 추가적으로 알게 된 부분
세세한 예외가 발생할 수 있는 부분을 잘 처리하자.