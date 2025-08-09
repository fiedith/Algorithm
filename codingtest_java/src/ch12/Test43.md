### [문제 43] Backtracking

정수 N을 입력받아 1~N 숫자 중 합이 10이 되는 조합을 리스트로 반환하는 solution() 함수 구현하라.

<span style="background-color: gray">정답 URL</span> https://github.com/retrogemHK/codingtest_java/blob/main/solution/43.java

---
### 제약 조건
- Backtracking 활용
- 숫자 조합은 오름차순 정렬
- 같은 숫자는 한 번만 선택 가능
- 1 <= N <= 10
---
### 입출력의 예
| N | return                                                        |
|---|---------------------------------------------------------------|
| 5 | [[1,2,3,4], [1,4,5], [2,3,5]]                                 |
| 2 | []                                                            |
| 7 | [[1,2,3,4], [1,2,7], [1,3,6], [1,4,5], [2,3,5], [3,7], [4,6]] |
