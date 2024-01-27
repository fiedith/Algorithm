# p. 315 볼링공 고르기 OPT
# based on solution

n, m = map(int, input().split())
balls = list(map(int, input().split()))

# weight arr
# weight limit: 1 ~ 10
weight =  [0] * 11

for ball in balls:
    weight[ball] += 1

# 1. combination of balls of equal weight are excluded
# 2. two balls of same weight are considered different
# result = combination of balls of weight 1 upto 10, 2 upto 10, 3 upto 10 ...

result = 0

for i in range(1, m + 1):
    # combination of each weight counters
    # decrement total balls n for each combination occurrences
    n -= weight[i]
    result += weight[i] * n

print(result)