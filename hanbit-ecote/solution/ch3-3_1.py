# p.96, NUMBER CARD GAME (solution #1)

n, m = map(int, input().split())

result = 0

for i in range(n):
    data = list(map(int, input().split()))
    
    # 현재 줄에서 최소갑 찾기: min() 활용
    min_value = min(data)
    
    # 최소값들 중 최대값을 찾기: max() 활용
    result = max(result, min_value)

print(result)