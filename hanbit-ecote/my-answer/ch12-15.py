# p.339 특정 거리의 도시 찾기
# https://www.acmicpc.net/problem/18352

from collections import deque

# n nodes, m edges, dist k, src x
n, m, k, x = map(int, input().split())

# adj list
adjacency = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    adjacency[a].append(b)

# added dest_depth(given as k)
def bfs(start_node):
    depth_table = [0] * (n + 1)
    queue = deque()
    # append start node number, depth
    queue.append((start_node, 0))

    while queue:
        node = queue.popleft()
        popped_number = node[0]
        popped_depth = node[1]

        if depth_table[popped_number] == 0:
            depth_table[popped_number] = popped_depth

        for connection in adjacency[popped_number]:
            queue.append((connection, popped_depth + 1))
    
    return depth_table

result = bfs(x)
if k not in result:
    print(-1)
else:
    for i in range(len(result)):
        if result[i] == k:
            print(i)