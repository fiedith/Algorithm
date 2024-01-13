# p.152 미로 탈출
# BFS 활용

from collections import deque

# (n, m)에 대해서 맵의 (세로길이, 가로길이)
n, m = map(int, input().split())

# 2-dimensional list 활용해 맵 구현
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# queue
queue = deque()

# counter
counter = -1

def bfs(x, y):
    global counter
    # 큐에 먼저 추가
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    
    # 길이 있다면
    if graph[x][y] == 1:
        temp_list = [x, y]
        queue.append(temp_list)
        counter += 1

    while queue:
        popped = queue.popleft()
        if popped[0] == n-1 and popped[1] == m-1:
            return False
        # 상하좌우 순서대로
        bfs(popped[0]-1, popped[1])
        bfs(popped[0]+1, popped[1])
        bfs(popped[0], popped[1]-1)
        bfs(popped[0], popped[1]+1)



while True:
    bfs(0,0)
print(counter)