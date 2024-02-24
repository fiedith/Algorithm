# p.351 감시 피하기
# https://www.acmicpc.net/problem/18428

from itertools import combinations

n = int(input())    
board = []  # N x N 복도 맵
teachers = []   # 모든 선생님 위치
spaces = []     # 모든 빈 공간 위치

for i in range(n):
    board.append(list(input().split()))
    for j in range(n):
        # 선생님의 위치 정보 저장
        if board[i][j] == 'T':
            teachers.append((i, j))
        # 빈 공간 위치 저장
        if board[i][j] == 'X':
            spaces.append((i, j))

# @return boolean(학생 발견: True, 미발견: False)
def watch(x, y, direction):
    # 좌 우 상 하 순서대로 0 1 2 3
    
    # 좌측으로 일자 감시
    if direction == 0:
        while y >= 0:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            y -= 1
    
    # 우측으로 일자 감시
    if direction == 1:
        while y < n:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            y += 1
    
    # 위쪽으로 일자 감시
    if direction == 2:
        while x >= 0:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            x -= 1
    
    # 아래쪽으로 일자 감시
    if direction == 3:
        while x < n:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            x += 1
    
    # 모든 좌우상하 방향으로 일자 감시했는데도 학생 발견 여부 없음
    return False

# @return boolean(모든 방향에서 watch() 수행한 결과)
def process():
    # 모든 선생님의 위치를 하나씩 확인한다
    # 문법 활용: teachers에 저장된 튜플 (x,y)을 하나씩 꺼내서 즉시 각각 x, y 변수로 활용 가능
    for x, y in teachers:
        # 4 방향으로 학생 감지 가능한지 확인한다
        for i in range(4):
            if watch(x, y, i):
                return True
    # 모든 방향으로 watch() 수행 결과 모두 False인 경우
    return False 

found = False
            
# 빈 공간에서 3개를 뽑는 모든 조합을 확인하는 코드
# combinations 사용법 알아볼 것
for data in combinations(spaces, 3):
    # 원본 복도 맵에 장애물을 설치해본다
    for x, y in data:
        board[x][y] = 'O'

    # 장애물을 설치하고 학생이 한 명도 감지되지 않는 경우 성공한 것이다
    if not process():
        find = True
        break
    
    # 설치했는데도 발견된 학생이 있는 경우 실패한 것이므로, 원상복구 후 다음 조합 구성
    for x, y in data:
        board[x][y] == 'X'

# 수행 결과 find에 따른 출력 결과
if find:
    print("YES")
else:
    print("NO")