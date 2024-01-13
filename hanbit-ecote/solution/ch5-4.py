from collections import deque

# n, m에 대해 맵의 (세로길이, 가로길이)
n, m = map(int, input().split())

# 2-d list
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 이동할 네 방향을 정의. 각각의 상-하-좌-우 이동에 대해 dx-dy index matching
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    # queue 정의
    queue = deque()
    # tuple 형태로 x, y좌표 append
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        # 현재 pop된 위치에서 상하좌우로 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 공간 이탈한 경우 다음 위치 탐색
            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                continue

            # 개인적으로 의미없는 코드라 판단해 주석처리
            # if graph[nx][ny] == 0:
            #     continue 

            # 길이 있는 경우 최단 거리 등록
            if graph[nx][ny] == 1:
                # 해당 위치의 값을 거리값으로 등록한다
                graph[nx][ny] = graph[x][y] + 1
                # 해당 좌표를 append
                queue.append((nx, ny))
            
            #  탈출 지점은 최소 경로값으로 될 것
    return graph[n-1][m-1]

print(bfs(0,0))