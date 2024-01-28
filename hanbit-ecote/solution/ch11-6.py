# p.316 무지의 먹방 라이브
# https://school.programmers.co.kr/learn/courses/30/lessons/42891

import heapq

def solution(food_times, k):

    if sum(food_times) < k:
        return -1
    
    # 시간이 작은 음식부터 빼기 위해 min priority queue 활용
    # queue 구성은 (음식 섭취 비용, 음식 번호)
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, ((food_times[i]), i + 1))

    # 먹기 위해 사용한 시간
    sum_value = 0

    # 직전에 다 먹은 음식 시간
    previous = 0

    # 남은 음식의 개수
    length = len(food_times)

    # q[0][0] : 현재의 음식 시간 (queue의 0번째 요소 = 가장 시간이 짧은 음식 = 지금 다 먹어야 하는 음식, 그 음식의 0번째 요소 = 섭취 시간)
    while sum_value + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0]   # 현재 가장 시간이 짧은 음식의 비용
        sum_value += (now - previous) * length   # 그 음식을 다 먹는데 걸리는 시간을 여태까지의 총 섭취 시간에 추가
        length -= 1     # 다 먹은 음식은 제외하므로 남은 음식의 개수는 감소됨
        previous = now  # 다음 음식을 없애기 위해 넘어가는데 이때 

    result = sorted(q, key = lambda x: x[1])    # 음식 번호 기준으로 정렬
    return result[(k - sum_value) % length][1]  # 여태까지 음식을 먹는데 걸린 비용 총합을 k에 빼고 길이만큼 나눈 나머지값의 음식 번호를 출력