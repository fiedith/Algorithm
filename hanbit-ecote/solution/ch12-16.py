# p.341 연구소
# https://www.acmicpc.net/problem/14502
# DFS / BFS (이 구현의 경우 DFS로) + 구현
# 모든 경우의 수를 구한다

n, m = map(int, input().split())

data = []   # 초기 맵 리스트
temp = [[0] * m for _ in range(n)]  # 벽 설치 후 맵 리스트

# input map infos
for _ in range(n):
    data.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

result = 0

# DFS 이용해 각 바이러스가 맵 사방으로 펴지게 세팅
def virus(x, y):
    for i in range(4):
        # 다음 이동할 위치
        nx = x + dx[i]
        ny = y + dy[i]

        # 바이러스가 퍼질 수 있는 맵 범위 확인
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            # 빈 공간인지 확인
            if temp[nx][ny] == 0:
                # 해당 위치에 바이러스 배치 후 재귀적 수행
                temp[nx][ny] = 2
                virus(nx, ny)

# 현재 맵에서 안전 영역의 크기 계산
def get_score():
    score = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                score += 1
    return score

# DFS를 이용해 울타리를 설치하며, 매번 안전 영역의 크기를 계산한다
def dfs(count):
    global result
    # 울타리가 3개 설치된 경우 (= end condition)
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = data[i][j]     # 벽 설치 후의 맵 상태 세팅
    
        # 각 위치를 확인하고 위치가 바이러스인 경우 사방으로 퍼지게 한다
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    virus(i, j)
        
        result = max(result, get_score())
        return
    
    # 빈 공간에 울타리 설치. 모든 경우에 대해 울타리 3개씩 설치하고 확인하며 result값을 재귀적으로 갱신시킴. 모든 경우가 계산된 경우 result값은 최대치에 도달함
    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                count += 1
                dfs(count)
                data[i][j] = 0
                count -= 1

dfs(0)
print(result)