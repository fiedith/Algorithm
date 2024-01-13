# p.115 왕실의 나이트

rows = ['1', '2', '3', '4', '5', '6', '7', '8']
columns = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']

# 예시 input: a1
position = input()
col_val = position[0]
row_val = position[1]

col_pos = columns.index(col_val)
row_pos = rows.index(row_val)
counter = 0

# 왼쪽 이동 가능 시
if col_pos - 2 >= 0:
    if row_pos - 1 >= 0:
        counter += 1
    if row_pos + 1 <= len(rows) - 1:
        counter += 1

# 오른쪽 이동 가능 시
if col_pos + 2 <= len(columns) - 1:
    if row_pos - 1 >= 0:
        counter += 1
    if row_pos + 1 <= len(rows) - 1:
        counter += 1

# 상 이동 가능 시
if row_pos - 2 >= 0:
    if col_pos - 1 >= 0:
        counter += 1
    if col_pos + 1 <= len(columns) - 1:
        counter += 1

# 하 이동 가능 시
if row_pos + 2 <= len(rows) - 1:
    if col_pos - 1 >= 0:
        counter += 1
    if col_pos + 1 <= len(columns) - 1:
        counter += 1

print(counter)