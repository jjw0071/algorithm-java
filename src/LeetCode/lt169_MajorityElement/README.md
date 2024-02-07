# MajorityElement

## 문제 이해
nums 배열이 주어지고 그 안에서 가장 많은 횟수 나타나는 값을 return해야한다.

## 문제 해결
HashMap을 만들고 key는 값, value는 횟수로 한다.  
nums 배열을 읽어오며 그 값이 hashmap에 있으면 찾아 값을 1더하고 아니면 새로 값을 넣는다.  
그리고 마지막에 모든 map들을 읽어오면서 나온 횟수가 nums 길이의 절반보다 크면 그 때 key를 return 한다.

## 문제 링크
https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

## 추가적으로 알게 된 부분
HashMap의 모든 Entry를 불러오는 방법