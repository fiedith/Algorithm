# p.311 모험가 길드

n = int(input())
members = list(map(int, input().split()))
members.sort()

group = []
counter = 0

while members:
    # 꺼낸 멤버의 숫자가 해당 그룹의 최소 인원수가 됨
    min_cap = members.pop(0)
    group.append(min_cap)
    if len(group) == min_cap:   
        counter += 1
        group.clear()

print(counter)