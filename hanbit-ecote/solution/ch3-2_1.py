# p.92, BIG NUMBER (simple solution)

# N: 배열의 크기, M: 더해지는 횟수, K: 동일 인덱스 덧셈 반복 최대 횟수
n, m, k = map(int, input().split())

numbers = list(map(int, input().split()))

# 오름차순 정렬
numbers.sort()

# 정렬된 상태이므로 맨 끝과 차순위 값이 제일 큰 두 수
first = numbers[n-1]
second = numbers[n-2]

# result initialization
result = 0

while True:
    for i in range(k):  # 가장 큰 수를 k번 더한다
        if m == 0:  # m이 0이면 break.
            break
        result += first
        m -= 1
    if m == 0:
        break
    result += second
    m -= 1

print(result)