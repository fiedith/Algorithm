# p.300 도시 분할 계획
# Kruskal's (MST)

# n nodes, m edges
n, m = map(int, input().split())

parent = [0] * (n + 1)
for i in range(1, n + 1):
    parent[i] = i

# find root
def find_parent(parent, a):
    if parent[a] != a:
        parent[a] = find_parent(parent, parent[a])
    return parent[a]

# union
def union_parent(parent, a, b):
    a_root = find_parent(parent, a)
    b_root = find_parent(parent, b)
    # set smaller value as root
    if a_root < b_root:
        parent[b_root] = a_root
    else:
        parent[a_root] = b_root
    

# Kruskal's alg

edges = []  # list to sort edges
result = 0  # min spanning cost
max_edge = 0

# input edge infos
for _ in range(m):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
        max_edge = max(max_edge, cost)
        
result -= max_edge
print(result)