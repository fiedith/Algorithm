# 떡의 개수 n, target m
n, m = map(int, input().split())

# 떡 길이 list
array = list(map(int, input().split()))

start = 0
end = max(array)

result = 0

def binary_search(array, start, end, target):
    global result
    # 잘라낸 떡의 총합
    total = 0
    if start > end:
        return result
    
    # mid는 잘라낼 위치, 즉 절단기의 길이를 나타냄
    mid = (start + end) // 2

    # 떡이 잘라낼 길이보다 길다면 잘라내고 총합에 더한다
    for item in array:
        if item > mid:
            total += item - mid
    
    # 잘라낸 떡의 총합이 target과 완전히 일치하다면 해당 절단기의 길이는 정답이 된다. 따라서 즉시 반환한다
    if total == target:
        return mid

    # 잘라낸 떡의 총합이 target보다 크다면 해당 절단기 길이는 결과의 후보가 되지만 더 작은 길이로 잘라낼 수 있는지 확인한다
    # 더 작은 길이로 잘라내기 위해서는 지금의 mid 값보다 더 큰 mid값을 찾아야 함. 따라서 mid+1 ~ end 지점을 탐색
    elif total > target:
        result = mid
        return binary_search(array, mid + 1, end, target)
    
    # 잘라낸 떡의 총합이 target보다 작은 상황이므로 해당 절단기 길이는 정답이 되지 못함.
    # 따라서 총합을 더 키워야 하며, mid 값을 작게 만들어야 하므로 start ~ mid-1 지점을 탐색
    else:
        return binary_search(array, start, end - 1, target)

print(binary_search(array, start, end, m))