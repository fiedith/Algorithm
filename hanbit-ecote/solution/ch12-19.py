# p.349 연산자 끼워 넣기
# https://www.acmicpc.net/problem/14888

# recursively check(dfs) for all cases

n = int(input())
numbers = list(map(int, input().split()))

add, sub, mul, div = map(int, input().split())

min_value = 1e9
max_value = -1e9

def dfs(i, now):
    global add, sub, mul, div, min_value, max_value

    # 모든 연산자를 다 사용했다면 최소값 최대값을 각각 업데이트
    if i == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
    
    else:
        # 각 연산자에 대해서 재귀적으로 실행한다
        if add > 0:
            add -= 1
            dfs(i + 1, now + numbers[i])
            add += 1
        
        if sub > 0:
            sub -= 1
            dfs(i + 1, now - numbers[i])
            sub += 1
        
        if mul > 0:
            mul -= 1
            dfs(i + 1, now * numbers[i])
            mul += 1
        
        if div > 0:
            div -= 1
            dfs(i + 1, int(now / numbers[i]))
            div += 1

dfs(1, numbers[0])

print(max_value)
print(min_value)

