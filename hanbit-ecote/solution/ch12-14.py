# p.335 외벽 점검
# https://school.programmers.co.kr/learn/courses/30/lessons/60062
from itertools import permutations

def solution(n, weak, dist):
    # 길이를 2배 늘려서 circular 형태 구현
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)
    # 투입할 친구의 최소값을 구해야 하므로 항상 min으로 갱신되게끔 최대값 + 1로 초기화
    answer = len(dist) + 1

    # 0부터 len-1까지 위치를 각각 시작점으로 설정
    for start in range(length):
        # 친구 나열하는 모든 각각의 경우의 수에 대해서 확인한다
        # permutations: 모든 조합 생성
        for friends in list(permutations(dist, len(dist))):
            count = 1   # 투입할 친구 수
            # 해당 친구가 점검할 수 있는 마지막 위치
            position = weak[start] + friends[count - 1]
            # 시작점부터 모든 취약 지점을 확인
            for index in range(start, start + length):
                # 점검 가능한 위치를 벗어난다면
                if position < weak[index]:
                    count += 1  # 새 친구 투입
                    # 투입이 더 안된다면 종료
                    if count > len(dist):
                        break
                    position = weak[index] + friends[count - 1]
            answer = min(answer, count) 
    if answer > len(dist):
        return -1
    return answer