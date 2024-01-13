# p.118 게임 개발

# (n, m)에 대서 n: 세로 길이, m: 가로 길이
n, m = map(int, input().split())

# 방문 여부를 저장할 리스트. 2차원 리스트로 가로 m 세로 n 크기
visited = [[0] * m for _ in range(n)]

# (npos, mpos)에 대해 좌측 상단이 (0, 0). 방향은 북동남서 기준으로 0123 순서, 왼쪽으로 돌기 때문에 방향은 -1씩 돈다
npos, mpos, direction = map(int, input().split())

# 북:0, 동:1, 남:2, 서:3 고려해서 각 바라보고 있는 방향별로 이동 가능한 경우를 index number로 매칭 구현
dn = [-1, 0, 1, 0]
dm = [0, 1, 0, -1]

# 플레이어 좌표를 방문 표기
visited[npos][mpos] = 1

def turn_left():
    global direction
    direction -= 1

    # 북 -> 서 -> 남 -> 동 사이클
    if direction < 0:
        direction = 3

# 지도 2차원 리스트 구현
map_list = []
for i in range(n):
    map_per_row = list(map(int, input().split()))
    map_list.append(map_per_row)


move_counter = 0    # 이동 횟수
turn_counter = 0    # turn_left() 횟수

# 시작
while True:
    turn_left()
    turn_counter += 1

    next_n = npos + dn[direction]
    next_m = mpos + dm[direction]

    # 이동이 가능하다면 포지션 변경, 해당 포지션 방문 표기, 이동 횟수 증가, turn_left() 횟수 초기화
    if visited[next_n][next_m] == 0 and map_list[next_n][next_m] == 0:
        npos = next_n
        mpos = next_m
        visited[npos][mpos] = 1
        move_counter += 1
        turn_counter = 0
        # 성능을 위해 바로 반복문 재실행
        continue

    # 이동 가능한 경로를 못 찾은 경우. 즉 한 바퀴 돌았는데 답이 없는 경우
    if turn_counter == 4:
        # 지금 방향 그대로 뒤로 이동할 준비
        next_n = npos - dn[direction]
        next_m = mpos - dm[direction]

        # 뒤가 바다(1) 라면 이동 불가
        if map_list[next_n][next_m] == 1:
            break

        # 이동 가능하다면 이동
        npos = next_n
        mpos = next_m
        move_counter += 1
        turn_counter = 0

print(move_counter)