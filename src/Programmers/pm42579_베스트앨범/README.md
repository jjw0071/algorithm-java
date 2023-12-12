# 베스트앨범

## 문제 이해
genres라는 배열에 재생된 음악의 장르들이 주어지고, plays는 각 앞서 genre에 있던 음악들이 플레이된 횟수가 주어진다.
이걸 참고해서 장르 별로 가장 많이 재생된 노래 2개씩 모아서 베스트 앨범을 만들 때 앨범에 수록되는 순서대로 genre의 index가 담긴 배열을
return 해야한다.

## 문제 해결
처음 든 생각은 2개의 HashMap을 만들어 해결하는 것이다. 1개의 HashMap에는 <String, Integer> 형태로 받아 각각의
장르별로 재생된 총 횟수를 확인하는 것이다. 이후에 sort를 해 가장 많이 재생된 장르부터 순차적으로 나열하려고 했다.
그리고 나머지 HashMap 에는 <String, HashMap> 형태로 넣어 장르별로 각각 hashmap을 새로 연결되게 하려고 하였다.
이 때 연결된 HashMap에는 재생횟수와, genres에서의 index가 들어가게 하려고 했다.
하지만 HashMap은 순서가 보장되지 않아서 다른 자료구조를 활용해야 했다. 그래서 검색 결과 HashMap을 만든 후 priorityqueue에 
넣어서 원하는 조건에 맞게 내림차순으로 정렬할 수 있다는 것을 알았다.
이를 위해서 첫번째 HashMap에 모두 넣고 그걸 PriorityQueue에 넣어서 순차적으로 나열되게 했고,
나머지 HashMap에서도 <String, PriorityQueue> 형태로 만들었다.
이때 두번째 HashMap의 Value인 PriorityQueue는 Map<Integer, Integer> 형태로 가지게 했고 Key 값이 재생횟수, Value 값이
Index로 만들었다. 그렇게 해서 새로 값이 추가 될때 재생횟수에 내림차순으로 나열되게 했고 재생횟수가 동일한 경우에는 value 값에 
오름차순으로 나열되도록 작성했다.


## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java

## 추가적으로 알게 된 부분
Comparator를 구현하고 Stream을 활용하는 방법에 대해 좀 더 공부해 보면 좋을 듯 하다.