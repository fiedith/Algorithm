def is_group(string):
    arr = list(string)
    while arr:
        popped = arr.pop(0)
        if popped in arr and popped != arr[0]:
            return False
    return True

n = int(input())
answer = 0
for i in range(n):
    word = input()
    if is_group(word):
        answer += 1

print(answer)