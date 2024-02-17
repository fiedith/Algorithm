# p. 344 경쟁적 전염
# 접근방법 BFS 
from collections import deque

n, k = map(int, input().split())

graph = []  # 전체 맵 정보
data = []   # 바이러스 정보를 담는 리스트

for i in range(n):
    # 전체 맵 정보 담기
    graph.append(list(map(int, input().split())))
    # 바이러스에 대한 정보를 담기
    for j in range(n):
        if graph[i][j] != 0:
            # 바이러스 번호, depth, x좌표, y좌표 담기
            data.append((graph[i][j], 0, i, j))

# 낮은 번호의 바이러스가 먼저 증식되게 오름차순으로 정렬
data.sort()
q = deque(data) # 바이러스 정보를 갖다가 큐로 만들음

# s, x, y
target_s, target_x, target_y = map(int, input().split())

# 바이러스가 퍼지는 경로를 북동남서 순서대로 (상우하좌)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# BFS
while q:
    virus, s, x, y = q.popleft()
    # depth가 target depth와 일치할 때까지 반복
    if s == target_s:
        break

    # 현재 노드에서 주변 4가지 위치를 각각 확인한다
    # dx[] dy[]와 같이 계속 쓰이는 패턴으로 다음 좌표인 nx ny를 먼저 만들고 유효한 move인지 검사
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        # 다음 위치가 맵 범위 내에 있는가
        if 0 <= nx and nx < n and 0 <= ny and ny < n:
            # 비어있는 위치이면 그 위치에 바이러스 넣기
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, s + 1, nx, ny))

print(graph[target_x - 1][target_y - 1])