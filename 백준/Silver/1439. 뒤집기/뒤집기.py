# p.313 문자열 뒤집기 

s = list(input())
numbers = [int(item) for item in s]

# 정답은 min 덩어리 숫자에 달림
switches = 0

for i in range(1, len(numbers)):
    if numbers[i] != numbers[i - 1]:
        switches += 1

switches = (switches/2) + 0.5
result = int(switches)

print(result)