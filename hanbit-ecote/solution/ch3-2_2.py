# p.92, BIG NUMBER (solution #2)

# N: 배열의 길이, M: 총 덧셈횟수, K: 동일숫자 연속 limit
n, m, k = map(int, input().split())

# 숫자들
numbers = list(map(int, input().split()))

# 오름차순 정렬
numbers.sort()

first = numbers[n-1]
second = numbers[n-2]

# 묶음 횟수 * k만큼 1등 수 더해주고 나머지만큼 추가 덧셈
first_counter = ((m // k)*k) + (m % (k+1))

# 묶음 수 만큼 2등 숫자 더해주기
second_counter = (m//k)

result = (first*first_counter) + (second*second_counter)

print(first_counter)
print(second_counter)

print(result)