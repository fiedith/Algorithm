### [문제 18] 두 개의 수로 특정값 만들기

n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을 때 이 중에서 합이 target인 두 수가 arr에 있는지 찾고, 있으면 true, 없다면 false를 반환하는 solution() 함수를 작성하세요.

<span style="background-color: gray">정답 URL</span> https://github.com/retrogemHK/codingtest_java/blob/main/solution/18.java

---
### 제약 조건
- n은 2이상 10,000 이하의 자연수
- arr의 각 원소는 1 이상 10,000 이하의 자연수
- arr의 원소 중 중복되는 원소는 없음
- target은 1 이상 20,000 이하의 자연수
---
### 입출력의 예
| arr             | target         | return |
|-----------------|----------------|-------|
| [1, 2, 3, 4, 5] | 6              | true  |
| [2, 3, 5, 9]    | 10             | false |