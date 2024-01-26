# Merge Sorted Array

## 문제 이해
2개의 integer Array(num1, num2)가 주어진다.  
그리고 2개의 integer m,n이 주어진다.  
각각 num1과 num2에 들어있는 요소의 개수이다.  
이 요소들을 오름차순으로 나열하여 num1에 넣어야 한다.  
즉 처음 num1의 사이즈는 m+n이다.

## 문제 해결
우선순위 큐를 만들어 num1, num2의 앞에서부터 m, n의 값들을 넣었다.  
그리고 순차적으로 꺼내 num1에 넣었다.

## 문제 링크
https://leetcode.com/problems/merge-sorted-array/description/?source=submission-ac

## 추가적으로 알게 된 부분
다른 사람들의 풀이를 보니 그냥 num2의 값들을 num1에 넣고 Arrays.sort(num1)을 하면 더
빠르게 해결할 수 있는 걸 확인했다.