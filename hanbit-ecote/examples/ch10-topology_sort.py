# p.290 topology sort
from collections import deque

# v nodes, e edges
v, e = map(int, input().split())

# each index indicates node, values indicate dest node
graph = [[] for _ in range(v + 1)]

# init all indegrees to 0
indegree = [0] * (v + 1)


# input edge infos
for _ in range(e):
    # node a to b
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

def topology_sort():
    q = deque()
    # sort result
    result = []

    # add all 0-indegree nodes to queue first
    for i in range(1, v + 1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        result.append(now)
        for node in graph[now]:
            indegree[node] -= 1
            if indegree[node] == 0:
                q.append(node)
    
    # show results
    for i in result:
        print(i, end = ' ')


topology_sort()
