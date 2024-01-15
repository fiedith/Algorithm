# p.237 simple dijkstra
# time complexity: O(V^2) when V nodes are given

import sys
input = sys.stdin.readline
INF = 987654321

# number of nodes n, vertices m
n, m = map(int, input().split())

# starting node number
start = int(input())

# list containing all nodes adjacent to each nodes. 
# index = node number
# value = tuple containing (adjacent node number, cost)
graph = [[] for i in range(n + 1)]

# input all vertices infos
for _ in range(m):
    # node a to node b costs c
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

# list to check if each nodes are visited or not
visited = [False] * (n + 1)

# shortest path table. each index number indicates each node numbers
distance = [INF] * (n + 1)

# get the least-costing unvisited node number
def get_smallest_node():
    min_value = INF
    index = 0

    for i in range(1, n+1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i

    return index

def dijkstra(start):
    # initialize starting node
    distance[start] = 0
    visited[start] = True

    # set min cost of each nodes adjacent to starting node  
    for i in graph[start]:
        distance[i[0]] = i[1]

    # for all nodes excluding the starting nodes
    for i in range(n-1):
        # next visiting node would be the currently closest node
        now = get_smallest_node()
        visited[now] = True

        for j in graph[now]:
            cost = distance[now] + j[1]
            # set min cost to min(existing_cost, new_cost)
            if cost < distance[j[0]]:
                distance[j[0]] = cost

# start
dijkstra(start)
for i in range(1, n+1):
    if distance[i] == INF:
        print("inf")
    else:
        print(distance[i])
