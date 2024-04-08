# p.92 큰 수의 법칙

# n numbers, total addition counter m, max consecutive addition k
n, m, k = map(int, input().split())

numbers = list(map(int, input().split()))
numbers.sort(reverse = True)

sets = m // (k + 1)
remainder = m % (k + 1)

first = numbers[0]
second = numbers[1]

answer = ((first * k) + second) * sets + (first * remainder)

print(answer)