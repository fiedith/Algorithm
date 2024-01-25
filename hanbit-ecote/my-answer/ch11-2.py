# p.312 곱하기 혹은 더하기

def add(a, b):
    return a + b

def mul(a, b):
    return a * b

# input numbers as list
numbers = input()

# set initial result
result = max(add(int(numbers[0]), int(numbers[1])), mul(int(numbers[0]), int(numbers[1])))


for i in range(2, len(numbers)):
    result = max(add(result, int(numbers[i])), mul(result, int(numbers[i])))

print(result)