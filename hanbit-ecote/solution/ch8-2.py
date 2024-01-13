# p.217 1로 만들기
# DP

x = int(input())

# 여기서 리스트는 해당 인덱스 숫자가 1을 만드는 데 갖는 최소 연산 횟수를 의미한다
d = [0] * 30001

for i in range(2, x + 1):
    # 현재 수에서 1을 빼는 경우
    d[i] = d[i - 1] + 1

    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)

    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5] + 1)

print(d[x])