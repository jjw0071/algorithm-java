# 단어 변환

## 문제 이해
문자열 형태의 변수 begin, target이 주어지고, 문자열 배열 words가 주어진다.  
이 때 한 번에 한 알파벳만 변경할 수 있고, words 내부의 단어로만 변경할 수 있다.  
이 때 begin변수 값을 target 변수 값으로 변환할 때 최소 몇 번 변환을 거쳐야 target으로 바꿀 수 있는지를
확인하는 문제이다.

## 문제 해결
먼저 words 안에 target 단어가 들어있는지 확인하고 없으면 0을 return 했다.  
있으면 이후에 값의 삽입 제거를 용이하게 하기 위해 words 내부의 값들을 linkedlist에 담았다.  
그리고 이후에 사용하기 위해 문자열, 숫자를 필드 값으로 가지는 클래스를 만들었다. 또한, 두 문자열을
알파벳별로 비교하여 다른 알파벳의 개수를 반환하는 함수도 구현했다.
이후에 먼저 words안의 값들 중 begin 단어와 알파벳이 한 개만 다를 경우 클래스형태로 만들어, depth는 1, 
문자열은 그 words안의 문자를 넣어 stack에 담았다. 이후에 계속 이런 식으로 알파벳이 하나씩만 다른
값들을 stack에 depth만 1씩 커지게 하여 담았다.
만약 뽑았을 때 target과 같으면, 51보다 작을 경우 그 클래스의 depth를 return하게 하였다.
DFS로 문제를 해결하였다.

## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java  
유사하지만 더 어려운 아래 문제도 풀어보자.
아래 문제를 풀어보면 이 풀이를 수정해야 함을 알 수 있다.
https://leetcode.com/problems/word-ladder/solutions/1010222/why-dfs-won-t-work/

## 추가적으로 알게 된 부분