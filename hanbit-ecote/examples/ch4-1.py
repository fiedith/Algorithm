# p.110 [상하좌우]
# 이동 방향에 따라 x, y값이 서로 매칭되게 구현

n = int(input())

x, y = 1, 1

actions = input().split()

# (x,y)에 대해서 x는 세로, y는 가로
# L: (0, -1)
# R: (0, 1)
# U: (-1, 0)
# D: (1, 0)

# L R U D 순서대로 dx, dy 위치가 짝지어짐.
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
possible_moves = ['L', 'R', 'U', 'D']

for action in actions:
    for i in range(len(possible_moves)):
        if action == possible_moves[i]:
            x += dx[i]
            y += dy[i]

            # 맵을 벗어나는 경우 rollback
            if x<1 or x>n:
                x -= dx[i]
            if y < 1 or y > n:
                y -= dy[i]

print(x, y)