# p. 315 볼링공 고르기

# requires opt

# n balls, max weight of m
n, m = map(int, input().split())

balls = list(map(int, input().split()))

result = 0

for outer in range(0, len(balls)):
    for inner in range(outer, len(balls)):
        if balls[inner] != balls[outer]:
            result += 1

print(result)