# flatten

## 문제 이해
평탄화 작업을 하는 문제이다.  
높이가 여러개 주어지고, 평탄화 가능 횟수가 주어진다.  
이 때 평탄화 시에는 가장 높은 칸에서 1개를 빼 가장 낮은 칸에 올려주면 된다.

## 문제 해결
ArrayList에 모든 높이 값들을 넣고 정렬한다.  
그리고 가장 높은 값, 가장 낮은 값을 뽑아 각각 1개씩 빼고 더한다. 
이 값들을 다시 넣고 정렬한다.  
이걸 평탄화 가능 횟수만큼 진행하고 가장 높은 값 - 가장 낮은 값을 return한다.

## 문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&problemLevel=4&contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=&orderBy=SUBMIT_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1

## 추가적으로 알게 된 부분
ArrayList에서 get으로 값을 받아오면 ArrayList에 실제 값은 그대로 존재한다. 빠지는게 아님!!!