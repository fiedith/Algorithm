# p.220 개미 전사

# 창고 용량
n = int(input())
storage = list(map(int, input().split()))

dp_table = [0] * (n + 1)

dp_table[1] = storage[0]
dp_table[2] = storage[1]

for i in range(3, n + 1):
    dp_table[i] = storage[i-1] + max(dp_table[:i-1])

print(max(dp_table))