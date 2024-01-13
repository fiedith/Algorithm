# p.223 바닥 공사

# dp table initialization
table = [0] * 1001

# floor of 2 x N
n = int(input())

# init the first two
table[1] = 1
table[2] = 3


for i in range(3, n + 1):
    # recurrence relation
    table[i] = (table[i-1] + 2 * table[i-2]) % 796796 

print(table[n])