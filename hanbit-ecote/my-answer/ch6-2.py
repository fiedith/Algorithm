n = int(input())

list = []

for i in range(n):
    list.append(int(input()))

list = sorted(list, reverse = True)

for i in range(n):
    print(list[i], end=" ")