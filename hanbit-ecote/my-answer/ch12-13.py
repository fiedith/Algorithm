# p.332 치킨 배달
# www.acmicpc.net/problem/15686

def distance(house, chicken):
    len_x = abs(house[0] - chicken[0])
    len_y = abs(house[1] - chicken[1])
    return len_x + len_y

INF = int(1e9)

# size n, max chickens m
n, m = map(int, input().split())

# whole map
city = []

# save each house and chicken positions as tuple of (row, col) tuple data
house_pos = []
chicken_pos = []

# append each chicken and house positions
# i: row, j: col
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(len(row)):
        if row[j] == 1:
            house_pos.append((i, j))
        elif row[j] == 2:
            chicken_pos.append((i, j))
    city.append(row)


chicken_infos = []
for i in range(len(chicken_pos)):
    length = 0
    for j in range(len(house_pos)):
        length += distance(chicken_pos[i], house_pos[j])
    chicken_infos.append((length, chicken_pos[i]))

chicken_infos.sort()
chicken_infos = chicken_infos[0 : m]


# table for min dist infos of house to chicken for each house
min_dist = [INF] * len(house_pos)

# set min dist table
for i in range(len(house_pos)):
    for j in range(len(chicken_infos)):
        min_dist[i] = min(distance(house_pos[i], chicken_infos[j][1]), min_dist[i])

result = 0
for value in min_dist:
    result += value

print(result)