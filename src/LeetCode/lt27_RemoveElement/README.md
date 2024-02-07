# RemoveElement

## 문제 이해
nums가 주어지고 val이 주어지는데 nums 내부의 값 중 val이 아닌 값의 개수를 return 해야한다.

## 문제 해결
그냥 처음부터 끝까지 읽으며 nums.length에서 빼면 될 것 같지만, 문제에서 채점 코드를 보여줬는데, 실제 nums의 값이 바뀌어야 했다.  
즉, 문제를 다 푼 후 nums 배열을 읽어 앞에서부터 정답으로 반환한 값만큼 읽어들여 확인하는 것이다.  
단순히 개수만을 return하면 안되고 실제 nums 내부의 값도 바뀌어야 한다.  
startIndex를 0, lastIndex를 nums.length-1로 놓고 처음 부터 읽어나갔다.  
그래서 nums[startIndex]의 값이 value이면 lastIndex 값과 바꾸고 lastIndex--를 했다.  
이렇게 해서 정답을 return했는데 실제 다른 사람들보다 메모리를 조금 많이 사용하는 것 같다.

## 문제 링크
https://leetcode.com/problems/remove-element/description/

## 추가적으로 알게 된 부분