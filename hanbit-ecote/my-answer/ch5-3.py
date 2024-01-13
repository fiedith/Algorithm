# p.149 음료수 얼려 먹기

# (n, m)에 대해 맵 전체의 (세로길이, 가로길이)
n, m = map(int, input().split())

graph = []
# 전체 맵을 2-dimensional list로 구성시킴
for i in range(n):
	graph.append(list(map(int, input())))

def dfs(x, y):
	# 맵 크기에서 이탈한 경우 구멍이 아님
	if x <= -1 or x >= n or y <= -1 or y >= m:
		return False

	# 미방문된 노드라면 방문하고 인접 미방문 노드 상대로 digging 시작
	if graph[x][y] == 0:
		# 해당 좌표 방문 처리
		graph[x][y] = 1
		dfs(x-1, y) # 상
		dfs(x+1, y) # 하
		dfs(x, y-1) # 좌
		dfs(x, y+1) # 우
		return True

	# 방문된 노드라면 구멍이 아님
	return False

# 총 얼음 counter
counter = 0

# 모든 좌표에 대해 dfs
for i in range(n):
	for j in range(m):
		if(dfs(i, j)):
			counter += 1

print(counter)
	