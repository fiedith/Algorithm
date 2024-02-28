from itertools import combinations

data = []   # 2d list map
teachers = []   # contains tuples of teacher pos of (x, y)
empty = []  # contains tuples of empty pos of (x, y)

n = int(input())
for i in range(n):
    data.append(list(input().split()))
    for j in range(n):
        if data[i][j] == 'T':
            teachers.append((i, j))
        if data[i][j] == 'X':
            empty.append((i, j))

# @param tuple(x, y), direction(0, 1, 2, 3)
# @return boolean (found student -> True)
def found(position, direction):
    x, y = position

    # 좌우상하 순서대로 0 1 2 3
    
    if direction == 0:
        while y >= 0:
            if data[x][y] == 'O':
                return False
            if data[x][y] == 'S':
                return True
            y -= 1
    
    if direction == 1:
        while y < n:
            if data[x][y] == 'O':
                return False
            if data[x][y] == 'S':
                return True
            y += 1
    
    if direction == 2:
        while x >= 0:
            if data[x][y] == 'O':
                return False
            if data[x][y] == 'S':
                return True
            x -= 1
    
    if direction == 3:
        while x < n:
            if data[x][y] == 'O':
                return False
            if data[x][y] == 'S':
                return True
            x += 1
    
    # 좌우상하 모두 감시했으나 발견 안됐다면 False
    return False

# @return boolean (False: 장애물로 모두 못 가린다, True: 모두 가려졌다)
def process():
    for pos in teachers:
        for i in range(4):
            if found(pos, i):   # 찾은 경우 즉시 False
                return True
    
    # 모든 방향으로 found()수행 결과 True가 도출되지 않는다면 False
    return False

result = False

for combo in combinations(empty, 3):
    for x, y in combo:
        data[x][y] = 'O'

    if not process():
        result = True
        break

    for x, y in combo:
        data[x][y] = 'X'



if result:
    print("YES")
else:
    print("NO")
