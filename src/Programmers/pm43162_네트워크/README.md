# 네트워크

## 문제 이해
이중 배열의 형태로 pc의 connection이 주어지고, 이 때, 간접적으로라도 연결되어 있으면 연결되어 있다고 간주한다.  
이 때 연결된 컴퓨터들이 한 네트워크 상에 있다고 하면, 총 네트워크의 개수를 반환하는 문제이다.

## 문제 해결
주어진 이중 배열의 값들을 읽어 그래프(ArrayList<LinkedList<Integer>>)로 만들고, 이 때 각 컴퓨터들이 연결되어 있는지
BFS로 확인하였다.

## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/43162

## 추가적으로 알게 된 부분