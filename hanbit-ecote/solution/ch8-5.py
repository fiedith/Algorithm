# p.226 효율적인 화폐 구성

# 화폐의 종류 n, target m
n, m = map(int, input().split())

bills = list(map(int, input().split()))

INF = 999999
dp_table = [INF] * (m + 1)
dp_table[0] = 0

for bill in bills:
    for i in range(bill, len(dp_table)):
        if dp_table[i - bill] != INF:
            dp_table[i] = dp_table[i - bill] + 1

if dp_table[m] != INF:
    print(dp_table[m])
else:
    print(-1)
