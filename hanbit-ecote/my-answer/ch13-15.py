# 특정거리 도시찾기
# BFS
from collections import deque

INF = int(1e9)

# n nodes, m edges, target cost k, src node x
n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for i in range(m):
    src, dest = map(int, input().split())
    graph[src].append(dest)

cost = [INF] * (n + 1)

def bfs(node):
    queue = deque()
    queue.append(node)
    cost[node] = 0
    while queue:
        popped = queue.popleft()
        for i in graph[popped]:
            if cost[i] == INF:
                cost[i] = cost[popped] + 1
                queue.append(i)

bfs(x)
exists = False
for i in range(len(cost)):
    if cost[i] == k:
        exists = True
        print(i)
if not exists:
    print(-1)