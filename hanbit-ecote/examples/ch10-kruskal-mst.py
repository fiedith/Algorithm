# p.281 min spanning tree (kruskal's algorithm)

# v nodes, e edges
v, e = map(int, input().split())
parent = [0] * (v + 1)
# parent of each node is set to the node itself
for i in range(1, v + 1):
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
    # set the smaller value be the root
    if a_root < b_root:
        parent[b_root] = a_root    
    else:
        parent[a_root] = b_root

# list to sort edges based on costs
edges = []
# min cost on creating spanning tree
result = 0

# input all edge infos
for _ in range(e):
    # node a to b costs cost
    a, b, cost = map(int, input().split())
    # save to edges list as tuple starting with cost in order to sort values by cost
    edges.append((cost, a, b))

# sort edges by cost
edges.sort()

for edge in edges:
    cost, a, b = edge

    # check for cycle occurrence, union nodes if no cycle occurs on union
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)
