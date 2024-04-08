# p.96 숫자 카드 게임

# n rows m cols
n, m = map(int, input().split())

min_list = []

for _ in range(n):
    row = list(map(int, input().split()))
    min_list.append(min(row))

answer = max(min_list)
print(answer)