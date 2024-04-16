n = int(input())

hours = [num for num in range(n + 1)]
mins = [num for num in range(60)]
secs = [num for num in range(60)]

answer = 0

for hour in hours:
    for min in mins:
        for sec in secs:
            time_str = str(hour) + str(min) + str(sec)
            if '3' in time_str:
                answer += 1

print(answer)