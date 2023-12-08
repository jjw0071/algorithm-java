# 완주하지 못한 선수

## 문제 이해
2개의 배열(participant, completion)이 주어지고, completion에는 완주한 선수, participant에는 전체 선수가 주어진다.
이 중에서 completion과 participant는 단 한 명의 플레이어만 차이가 있고 이 플레이어가 완주하지 못한 선수이다.
이 완주하지 못한 선수를 찾는 것이 문제이다.


## 문제 해결
처음에는 그냥 arraylist에 넣어서 contains를 이용해서 문제를 해결하려 했으나, 이는 시간도 오래 걸리고, 또한 동명이인이 존재할 경우 문제를 해결할 수 없었다.
그래서 completion 배열을 한번씩 읽으면서 hashmap에 key 값으로 Player 이름, value로 숫자를 넣었다. 이 value를 통해서 동명이인을 확인하였다.
그리고 완주하지 못한 선수를 확인하는 방법은 participant의 값들을 하나씩 읽어오며 hashmap에 포함되어 있는지 확인하고, 없으면 그 이름을 return하게 하였다.
만약 hashmap에 이미 존재하는 경우 그 vlaue를 확인하였다. 그 value가 0보다 크면 동명이인인 경우 이므로 그 값을 1감소시켜서 값을 수정하고 넘어가고, 0이면 이미
동명이인을 다 확인한 경우이므로 그 때의 player 이름ㅇ르 return 하였다.

## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java