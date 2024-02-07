# Remove Duplicates from Sorted Array

## 문제 이해
nums라는 배열이 주어지고, 이 배열에는 값들이 들어있다.  
중복되는 값이 나올 경우 처음 값만 제대로 들어있고 그 뒤의 값은 나오지 않아야 한다.  
그 결과 서로 다른 값의 개수를 return하는 함수를 만들어야 한다.  
그 결과 함수를 실행한 후 nums를 앞에서부터 k개 읽었을 때 모두 다른 값이 나와야 하고, 이 값들의 나열 순서는 처음 nums에서의 나열 순서와 같아야 한다.

## 문제 해결
answer라는 int를 만들었다. 초기값은 0이다.  
boolean[]을 하나 만들어 여기에는 앞선 나온 값인지 확인해 확인 했을 경우 true로 바꾸어 주었다.  
처음 nums에 -100 ~ 100까지 있으므로 boolean[]은 201개의 값을 가지게 했고 나온 값에 100을 더해 그 index를 값으로 확인했다.  

예를 들어 -100이 값으로 나오면 100을 더해 boolean[0]을 확인하고, 3이 나올 경우 100을 더해 boolean[103]을 확인하는 것이다.  
이 때 순차적으로 값을 확인해 이미 나온 값이면 지나가고 아직 나온 값이 아니면 nums[answer] = 나온 값으로 바꾸고, answer++, checked[값+100] = true로 바꾸어 주었다.  
이렇게 하면 이미 나온 값일 경우 nums의 다음 값을 보게 된다.  
그리고 answer을 nums의 index로 사용해 순차적으로 처음 나온 값들만 바뀌게 된다.


## 문제 링크
https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1160756037/?envType=study-plan-v2&envId=top-interview-150

## 추가적으로 알게 된 부분