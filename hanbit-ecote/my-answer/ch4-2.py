# p.115 왕실의 나이트

# e.g. a1, c4, g2
pos = list(input())

BOARD_SIZE = 8
cols = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
rows = ['1', '2', '3', '4', '5', '6', '7', '8']


# (row idx, col idx)
moves = [(-2, 1), (-2, -1), (2, 1), (2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]

for i in range(BOARD_SIZE):
    if pos[0] == cols[i]:
        col_idx = i

for i in range(BOARD_SIZE):
    if pos[1] == rows[i]:
        row_idx = i

pos_pair = (row_idx, col_idx)

answer = 0
for move in moves:
    next_row = pos_pair[0] + move[0]
    next_col = pos_pair[1] + move[1]

    if next_row < 0 or next_row > BOARD_SIZE or next_col < 0 or next_col > BOARD_SIZE:
        continue
    answer += 1

print(answer)