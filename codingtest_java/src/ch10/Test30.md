### [문제 30] 간단한 union-find 알고리즘 구현하기

operations라는 배열은 수행할 연산을 의미한다. 연산 종류는 2가지이다.
- [0, 1, 2]: 노드1과 노드2에 대해 union 연산 수행, 반환값은 없음
- [1, 1, 3]: 노드1과 노드3이 같은 집합에 속해 있으면 true, 아니면 false를 반환하는 연산

**초기의 노드는 부모 노드를 자신의 값으로 설정했다고 가정하며**, operations에 있는 연산에 대한 결과를 연산 순서대로 담은 Boolean 배열을 반환하는 solution() 메서드를 구현하라

<span style="background-color: gray">정답 URL</span> https://github.com/retrogemHK/codingtest_java/blob/main/solution/30.java

---
### 제약 조건
- solution(int k, int[][] operations)
- 노드의 개수 k는 1000 이하 
- i = len(operations)일 때  1 ≦ i ≦ 100,000 
- operations[i][0]은 정수 0 혹은 1
- operations[i]에 담긴 배열 [n, x, y]에 대해 x와 y는 0 이상 k-1 이하의 정수