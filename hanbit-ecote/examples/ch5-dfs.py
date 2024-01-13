# p.137 dfs

def dfs(graph, start, visited):
    # starting vertex를 방문 처리
    visited[start] = True
    print(start, end=' ')

    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[start]:
        # 방문되지 않았다면
        if not visited[i]:
            dfs(graph, i, visited)

# graph expressed in 2-dimensional list
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

# list to keep track of visited vertices
visited = [False] * 9

dfs(graph, 1, visited)