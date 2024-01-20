# p.277 using union-find for cycle detection
# only valid for undirected graphs

# v nodes, e edges
v, e = map(int, input().split())
parent_table = [0] * (v + 1)
# set all nodes' parent be the node itself
for i in range(1, v + 1):
	parent_table[i] = i

# find root
def find_parent(parent, a):
	if parent[a] != a:
		parent[a] = find_parent(parent, parent[a])
	return parent[a]

# union
def union_parent(parent, a, b):
	a_root = find_parent(parent, a)
	b_root = find_parent(parent, b)
	# select smaller root value as the common root value
	if a_root < b_root:
		parent[b_root] = a_root
	else:
		parent[a_root] = b_root

cycle = False
# input all edge infos. perform union for each edges
for i in range(e):
	# edge connects node a and b
	a, b = map(int, input().split())
	# check for cycle occurrence
	if find_parent(parent_table, a) == find_parent(parent_table, b):
		cycle = True
		break
	
	# if no cycle exists, union two nodes
	union_parent(parent_table, a, b)

print(cycle)