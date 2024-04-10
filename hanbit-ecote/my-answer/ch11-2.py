# p.312 곱하기 혹은 더하기

s = input()
arr = list(s)

result = int(arr.pop(0))

while arr:
    popped = int(arr.pop(0))
    sum = result + popped
    mul = result * popped
    result = max(sum, mul)

print(result)