# 배열에서 검색
1. 선형 검색 : 무작위로 늘어서 있는 데이터 모임에서 검색을 수행
2. 이진 검색 : 일정한 규칙으로 늘어서 있는 데이터 모임에서 아주 빠른 검색 수행
3. 해시법 : 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색 수행
   - 체인법 : 같은 해시값의 데이터를 선형 리스트로 연결
   - 오픈 주소법 : 데이터를 위한 해시값이 충돌할 때 재해시하는 방법

## 선형검색(linear search), 순차 검색(sequential search)
요소가 직선 모양으로 늘어선 배열에서 원하는 키값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 검색

### 종료 조건
1. 검색할 값을 발견하지 못하고 배열의 끝을 지나간 경우
2. 검색할 값과 같은 요소를 발견한 경우

보초법을 통해 종료 조건의 검사비용을 반으로 줄일 수 있음
### 보초법(sentinel method)
초기의 배열 맨 끝 요소로 검색하고자 하는 키값을 저장해 놓는 것<br>
이를 통해 종료 조건 1 없이 종료 조건 2만 있으면 종료 가능.