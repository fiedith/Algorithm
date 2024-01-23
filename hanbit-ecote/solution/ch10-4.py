# p.303 커리큘럼
# topology sort

from collections import deque
import copy

# v nodes
v = int(input())

indegree = [0] * (v + 1)
graph = [[] for _ in range(v + 1)]
# time data for each nodes
time = [0] * (v + 1)

# input all node infos
# input format: (time, prerequisites... , EOL)
# i = dest node
for i in range(1, v + 1):
    data = list(map(int, input().split())) # input as list
    time[i] = data[0]
    
    # every other data inbetween time and EOL are prerequisites
    # x = pre-node, aka src node
    for x in data[1:-1]:
        indegree[i] += 1
        graph[x].append(i)

def topology_sort():
    result = copy.deepcopy(time)    # get a copy of time list
    q = deque()

    # push all 0-indegree nodes to queue
    for i in range(1, v + 1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()

        for i in graph[now]:
            result[i] = max(result[i], result[now] + time[i])   # updating result table logic
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

    for i in range(1, v + 1):
        print(result[i])

topology_sort()




