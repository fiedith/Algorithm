# p.118 게임 개발
# 포인트: visited 리스트 사용하는 방법, 2차원 리스트 활용법, 문제에서 왜 동남북서 방향을 0123으로 지정했는지를 파악하기

# (n, m)에 대해서 (세로길이, 가로길이)
n, m = map(int, input().split())

# 방문된 위치를 저장하기 위한 list
visited = [[0] * m for _ in range(n)]

# 현재 캐릭터의 x좌표, y좌표, 방향 입력. (x, y)에 대해서 좌측 상단이 (0, 0)
global direction
x, y, direction = map(int, input().split())

# 현재 위치 방문 표시
visited[x][y] = 1

# 전체 맵 정보
map_array = []
for i in range(n):
    map_array.append(list(map(int, input().split())))

# 북, 동, 남, 서로 직진하는 경우. 북:0 동:1 남:2 서:3 이므로.
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 왼쪽으로 돈다는 것은 방향을 -1 하는 것. 북:0 동:1 남:2 서:3 이므로.
def turn_left():
    # 방향 변수를 전역화
    global direction
    direction -= 1
    if direction == -1:
        direction = 3

# simulation start
turn_count = 0
move_counter = 0

while True:
    turn_left()
    next_x = x + dx[direction]
    next_y = y + dy[direction]
    
    # 회전 후 이동 가능한지 확인, 가능하면 이동
    if visited[next_x][next_y] == 0 and map_array[next_x][next_y] == 0:
        x = next_x
        y = next_y
        turn_count = 0
        move_counter += 1
        
        # 방문 표시
        visited[x][y] = 1
        
        # 성능을 위해 이후의 조건문 check 없이 바로 loop
        continue
    # 가능하지 않다면 회전 횟수 증가
    else:
        turn_count += 1
    
    # 전 방향 탐색 후에도 답이 없다면 뒤로 후진 조건 확인
    if turn_count == 4:
        next_x = x - dx[direction]
        next_y = y - dx[direction]

        # 후진 위치가 바다인 경우 반복문 종료.
        if map_array[next_x][next_y] == 0:
            x = next_x
            y = next_y
        
        else:
            break

        turn_count = 0

        # 후진도 1회 이동으로 치기 때문
        move_counter += 1

print(move_counter)