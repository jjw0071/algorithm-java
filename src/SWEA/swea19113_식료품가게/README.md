# 식료품 가게

## 문제 이해
2n개의 숫자가 주어진다. 원래 n개의 값과 그 값들의 75%인 값들을 따로 표기해야 하는데, 한 번에 다 표기되어진 것이다.
따라서 이 2n개의 숫자를 읽고 원래 값들 중 75% 할인된 값들만 뽑아내야 한다.

## 문제 해결
우선순위 큐를 이용해 해결했다. 2개의 우선순위 큐를 만들어 1개에는 처음 입력으로 주어지는 걸 모두 넣고, 이 안에서 작은 것 부터
순차적으로 하나씩 뽑아서 확인했다.  
뽑은 값을 보고 이 값에 4/3을 곱해서 그 값이 이 큐에 있으면 새로운 큐에 뽑았던 값을 넣고 원래 큐에서 4/3을 곱한 값을 제거한다.
이런식으로 큐를 전부다 한 번 확인 한 후, 새로운 큐에 남아있는 것들만 순차적으로 뽑아서 출력했다.

## 문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYxCRFA6iiEDFASu&categoryId=AYxCRFA6iiEDFASu&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

## 추가적으로 알게 된 부분