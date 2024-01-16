# p.248 dijkstra using heap (min-priority queue)
# time complexity: O(ElogV) when E edges and V nodes are given

import heapq
import sys
input = sys.stdin.readline
INF = 987654321

# n nodes and m edges
n, m = map(int, input().split())

# starting node number
start = int(input())

# list containing adjacent nodes for each nodes
# index = node number
# value = tuples containing (adjacent node number, cost)
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    # node a to b costs c
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

distance = [INF] * (n + 1)

def dijkstra(start):
    q = []
    # push (distance, node number) into q
    # distance in (distance, node number) will be considered as priority
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        # popped node is considered visited if min cost is smaller than popped cost info
        if distance[now] < dist:
            continue

        # if not visited, check costs for all adjacent nodes to current node
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                # push renewed cost info to heap
                heapq.heappush(q, (cost, i[0]))

# start 
dijkstra(start)
for i in range(1, n + 1):
    if distance[i] == INF:
        print("inf")
    else:
        print(distance[i])
