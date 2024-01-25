# p.311 모험가 길드

n = int(input())
# 공포도 list
data = list(map(int, input().split()))
data.sort()

result = 0

# 현재 그룹에 포함된 모험가 수
count = 0

# 공포도를 오름차순으로 확인
for i in data:
    count += 1
    if count >= i:
        result += 1
        count = 0