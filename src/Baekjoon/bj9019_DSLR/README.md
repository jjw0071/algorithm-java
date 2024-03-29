# DSLR

## 문제 이해
n이 주어진다. n은 0이상 10,000미만이다.
D,S,L,R의 연산이 각각 주어진다.  
그리고 원하는 결과가 주어진다.  
n을 연산 결과 원하는 결과 값을 만드는 연산을 반환해야 하는데 최소한의 연산을 통해서 결과 값을 만들어야 한다.  

## 문제 해결
BFS를 통해 처음 받은 수에서 각각 연산을 해가며 그 연산 결과가 원하는 결과와 맞는지 찾아야 겠다.

### BFS
Data (지금까지의 명령어와 현재 숫자 값을 가지는 class) 생성했다.  
BFS는 queue에 data class을 넣어서 진행했다.  
그리고 처음에 한번 돌면서 d,s,l,r 연산을 진행하고, 그 값들을 data로 만들어 queue에 넣었다.  
queue가 빌 때 까지 계속 큐에서 값을 꺼내 D,S,L,R 연산을 진행하고 새로운 data를 만들어 넣도록 했다.  
그러다 연산 결과가 end와 동일하면 그 연산을 return 하게 했다.  

이렇게 해서 답은 나왔으나 제출 했을 때 메모리초과가 발생했다.

HashSet을 만들어 연산 결과를 받아 이전에 한번 확인한 연산 값들은 다시 연산할 필요가 없도록 했다.  
그런데 이번에는 시간초과가 발생한다.

다른 해설을 찾아보았다.  
그 풀이에서는 boolean 배열 visited[10000]과 String 배열 command[10000]을 만들어 각 자리의 index를 이용해 방문했는지와 거기까지 갈 때의 command를 저장했다.  
그래도 계속 시간초과가 발생했다.

문제는 한자리씩 뒤로 밀고 한자리씩 앞으로 당기는 연산에서 발생한 것이었다.  
나는 이걸 배열을 만들어 하나씩 이동시킨후 다시 숫자로 변형하는 방식을 사용했는데, 이것 때문에 시간이 너무 오래 걸린 것이다.  
새롭게 %10과 *1000을 이용해 배열로 변환시키지 않고 자리를 이동하니 시간초과가 발생하지 않았다.

## 문제 링크
https://www.acmicpc.net/problem/9019

## 추가적으로 알게 된 부분
어떤 작업을 할 때 더 간단하게 (새로운 배열을 만든다거나 형변환 등의 작업 없이) 작업할 수 있게 구현하도록 노력해 보자.