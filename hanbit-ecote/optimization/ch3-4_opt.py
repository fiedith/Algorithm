# p.99 [1이 될 때까지] OPTIMIZATION
# 반복문으로 counter을 증가시키는게 아니라, 목표값과 목표값까지 도달하는 데 걸리는 걸음 수 개념 활용

n, k = map(int, input().split())

counter = 0

while True:
    target = (n // k) * k
    counter += n - target
    n = target

    if n < k:
        break

    n //= k
    counter += 1

# 중요: n=1으로 도착한 경우 counter수는 동일하지만, n=0으로 도착한 경우에는 1을 빼야 함.
counter += (n - 1)
print(counter)