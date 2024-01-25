# p.313 문자열 뒤집기 
# 접근 방법: 앞뒤의 수가 서로 달라지는 경우의 수의 절반값이 정답

numbers = input()
switches = 0

for i in range(1, len(numbers)):
    if numbers[i - 1] == numbers[i]:
        continue
    switches += 1

if switches % 2 == 0:
    print(switches//2)
else:
    print(switches//2 + 1)