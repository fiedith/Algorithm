# p.143 bfs

from collections import deque

def bfs(graph, start, visited):
    # deque 활용해 queue 구현
    queue = deque([start])
    visited[start] = True

    # queue가 빌 때까지
    while queue:
        # queue에서 하나 pop 해오기
        v = queue.popleft()
        print(v, end=' ')

        # append all unvisited nodes adjacent to the node popped 
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                # mark all of those nodes added as visited
                visited[i] = True

visited = [False] * 9

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

bfs(graph, 1, visited)