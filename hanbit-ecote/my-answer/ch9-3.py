# p.262 전보
# dijkstra

import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

# n nodes, m edges, starting point start
n, m, start = map(int, input().split())

# each index number indicates node number, value contains tuple of (dest node, cost)
graph = [[] for _ in range(n + 1)]

# min cost table
distance = [INF] * (n + 1)

# input all nodes infos
for _ in range(m):
    # node a to b costs k
    a, b, k = map(int, input().split())
    graph[a].append((b, k))

# dijkstra
def dijkstra(start):
    # heap
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)
        # current node is considered visited if popped dist > saved min cost
        if dist > distance[now]:
            continue

        # node[0] = adjacent node no., node[1] = cost to corresponding node
        for node in graph[now]:
            new_cost = dist + node[1]
            # update min cost if new_cost is smaller than saved min cost
            if new_cost < distance[node[0]]:
                distance[node[0]] = new_cost
                heapq.heappush(q, (new_cost, node[0]))
            
# start
dijkstra(start)
messaged_nodes = 0
messaged_time = []
for i in range(1, n + 1):
    if distance[i] != INF:
         if distance[i] != 0:
            messaged_nodes = messaged_nodes + 1
            messaged_time.append(distance[i])

max_time = max(messaged_time)

print(messaged_nodes, max_time)