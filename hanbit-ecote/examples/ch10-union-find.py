# p.268 union-find structures

# input v nodes and e edges (edges serve as number of union operations)
v, e = map(int, input().split())
# table indicating each node's parents
parent = [0] * (v + 1)

# find
# optimized using compression
def find_parent(parent, x):
    # recursively search root node
    if parent[x] != x:
        # compression: replace parent node to root node and return it
        parent[x] = find_parent(parent, [parent[x]])
    return parent[x]

# union
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    # smaller root value becomes the root node for union set
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# set each node's parent be the node itself
for i in range(1, v + 1):
    parent[i] = i

# perform union for each edge
for i in range(e):
    # node a and b would be union'd
    a, b = map(int, input().split())
    union_parent(parent, a, b)

# print each union set of nodes
# sharing a root node is equal to being in a union set
print('union set(root node): ', end=' ')
for i in range(1, v + 1):
    print(find_parent(parent, i), end = ' ')
print()