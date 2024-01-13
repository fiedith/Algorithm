# p.149 음료수 얼려 먹기
# 접근 방법: BFS

# (n, m)에 대해 (세로길이, 가로길이)
n, m = map(int, input().split())

graph = []

# 세로 길이 n이 반복을 결정
for i in range(n):
    graph.append(list(map(int, input())))

def dfs(x, y):
    # 범위 이탈 시 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    
    # 노드가 방문되지 않았다면
    if graph[x][y] == 0:
        # 방문 처리
        graph[x][y] = 1
        # 상하좌우 모든 위치에 대해서 재귀적으로 호출
        # 상
        dfs(x - 1, y)
        # 좌
        dfs(x, y - 1)
        # 하
        dfs(x + 1, y)
        # 우
        dfs(x, y + 1)
        return True
    return False

counter = 0
for i in range(n):
    for j in range(m):
        # 현재 위치에서 DFS
        if dfs(i, j) == True:
            counter += 1

print(counter)