# p.327 뱀
# www.acmicpc.net/problem/3190

n = int(input())    # map size
k = int(input())    # apples

# map info
data = [[0] * (n + 1) for _ in range(n + 1)]

# direction switch info
info = []

# input apple infos
for _ in range(k):
    a, b = map(int, input().split())
    data[a][b] = 1  # mark apple as 1


# input direction switch infos
l = int(input())
for _ in range(l):
    x, c = input().split()  # x초에 c방향으로 전환
    info.append((int(x), c))

# east, south, west, north
# 초기 상태는 동쪽을 바라보는 상태. 순차적으로 오른쪽으로 도는 방향. 왼쪽은 반대로.
dx = [0, 1, 0, -1]      # rows
dy = [1, 0, -1, 0]      # columns

def turn(direction, c):
    if c == 'L':
        direction = (direction - 1) % 4
    else:
        direction = (direction + 1) % 4
    return direction

def simulate():
    x, y = 1, 1     # 뱀 머리 좌표
    data[x][y] = 2      # 뱀이 존재하는 위치를 2로 표시
    direction = 0   # 초기 방향은 동쪽을 바라보는 상태
    time = 0    # 게임 시작 후 흐른 시간
    index = 0   # 다음에 회전할 정보
    q = [(x, y)]    # 뱀이 차지하고 있는 위치 정보, 앞에 있는 데이터가 꼬리 데이터
    
    while True:
        # next x and next y
        nx = x + dx[direction]
        ny = y + dy[direction]

        # 맵 범위 안에 있고 뱀의 몸통이 없는 위치라면 발동\
        if 1 <= nx and nx <= n and 1 <= ny and ny <= n and data[nx][ny] != 2:
            # 사과가 없다면 이동하고 꼬리 제거
            if data[nx][ny] == 0:
                data[nx][ny] = 2
                q.append((nx, ny))
                px, py = q.pop(0)   # 꼬리 제거
                data[px][py] = 0  # 꼬리가 제거됐으므로 0으로 표시

            # 사과가 있다면 이동하되 꼬리는 유지
            if data[nx][ny] == 1:
                data[nx][ny] = 2
                q.append((nx, ny))
        
        # 벽을 만나거나 몸통을 만난다면 종료.
        else:
            time += 1
            break

        # 다음 위치로 머리 이동
        x, y = nx, ny
        time += 1

        # 회전할 시간인 경우 회전하기 
        if index < l and time == info[index][0]:
            direction = turn(direction, info[index][1])
            index += 1
    return time

print(simulate())

