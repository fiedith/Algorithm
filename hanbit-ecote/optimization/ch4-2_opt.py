# p.115 왕실의 나이트
# ch4-1 상하좌우와 비슷한 풀이 방식으로 풀 것이 권장된다.
# ord() 함수: 문자에 해당하는 unicode를 반환함

position = input()
row = int(position[1])

# ord 활용: unicode상 abc 순서대로 번호가 부여되므로 a로부터 얼마나 떨어져 있는지를 토대로 포지션을 삼는 방식
column = int(ord(position[0]) - int(ord('a'))) + 1

# 이동 가능한 모든 방향들을 정의
# (x, y)에 대해 x: column, y = row
steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (1, -2), (-1, 2), (1, 2)]

counter = 0

for step in steps:
    next_col = column + step[0]
    next_row = row + step[1]

    if next_col >= 1 and next_col <= 8 and next_row >= 1 and next_row <= 8:
        counter += 1

print(counter)