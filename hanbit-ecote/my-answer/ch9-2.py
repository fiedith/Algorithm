# p.259 미래 도시
# floyd warshall

INF = int(1e9)

# n nodes, m edges
n, m = map(int, input().split())

# 2-dimensional list for min cost
# given graph[a][b] = k, node a to b costs k
graph = [[INF] * (n + 1) for _ in range(n + 1)]



# cost to self node always costs 0
for i in range(n + 1):
    for j in range(n + 1):
        if i == j:
            graph[i][j] = 0

# input all edge infos
for _ in range(m):
    # node a to b costs 1, two-way graph
    a, b= map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

# input x, k
x, k = map(int, input().split())

# floyd warshall
for k in range(n + 1):
    for a in range(n + 1):
        for b in range(n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# result: min cost of 1->k->x
result = graph[1][k] + graph[k][x]

if result >= INF:
    print(-1)
else:
    print(result)