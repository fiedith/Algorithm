# p.99 1이 될 때까지

# number n, divisor k
n, k = map(int, input().split())
counter = 0

while n != 1:
    if n % k == 0:
        n = n // k
    else:
        n -= 1
    counter += 1

print(counter)