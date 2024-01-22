# p.298 팀 결성
# union-find

# n teams, m inputs
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
    

find_results = []
for i in range(m):
    # a: command input. b, c: two nodes
    a, b, c = map(int, input().split())
    # assuming only two commands 0 and 1 exist
    if a == 0:
        union_parent(parent, b, c)
    else:
        find_results.append(find_parent(parent, b) == find_parent(parent, c))

print(find_results)