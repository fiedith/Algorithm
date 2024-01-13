# p.96 [NUMBER CARD GAME]
# 접근 방법: 각 행마다 최소값을 구한 후 모든 최소값들 중 최대값을 정답으로 삼는다

n, m = map(int, input().split())

rows = []
for i in range(n):
    numbers = list(map(int, input().split()))
    numbers.sort()
    rows.append(numbers)

result = rows[0][0]

for i in range(n):
    if result < rows[i][0]:
        result = rows[i][0]

print(result)