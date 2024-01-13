# p. 113 시각

# 시
n = int(input())

# 개수
counter = 0

# 시
for i in range(n+1):
    # 분
    for j in range(60):
        # 초
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                counter += 1

print(counter)