# p.217 1로 만들기

n = int(input())

INF = 99999999

# index = n
# value = least operation (answer)
dp_table = [INF] * 150001
dp_table[1] = 0

for i in range(1, n+1):
    dp_table[i + 1] = min(dp_table[i + 1], dp_table[i] + 1)
    dp_table[i * 2] = min(dp_table[i * 2], dp_table[i] + 1)
    dp_table[i * 3] = min(dp_table[i * 3], dp_table[i] + 1)
    dp_table[i * 5] = min(dp_table[i * 5], dp_table[i] + 1)

print(dp_table[n])