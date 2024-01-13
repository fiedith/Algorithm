# 책에 나온 해답이며 개인적으로는 내 풀이 정도면 더 이상의 optimization은 불필요하다고 판단된다.

# (x, y) 기준 x: 세로, y: 가로
x, y = 1, 1

# L R U D 순서대로
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
available_moves = ["L", "R", "U", "D"]

n = int(input())
actions = input().split()

for action in actions:
    for i in range(len(available_moves)):
        if action == available_moves[i]:
            # 임의의 변수를 사용해 일시적으로 다음 경로로 이동하는 칸 수를 담음
            nx = x + dx[i]
            ny = y + dy[i]
        
        if nx < 1 or nx > n or ny < 1 or ny > n:
            continue

        x = nx
        y = ny

print(x, y)