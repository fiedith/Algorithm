INF = int(1e9)

# n nodes, m edges
n, m = map(int, input().split())

# 2-dimensional list initialized with INFs
# assuming graph[i][j] = k, node i to node j costs k (min)
graph = [[INF] * (n + 1) for _ in range(n + 1)]

# route to self node are always 0
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            graph[i][j] = 0

# get all edges' infos
for _ in range(m):
    # node a to b costs c
    a, b, c = map(int, input().split())
    graph[a][b] = c

# floyd warshall's algorithm based on recurrence relation
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# show results
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if graph[a][b] == INF:
            print("inf", end = ' ')
        else:
            print(graph[a][b], end = ' ')
    print()
