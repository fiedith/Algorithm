# p.201 떡볶이 떡 만들기
# 접근 방식: binary search (loop ver.)

# array size n, target value m
n, m = map(int, input().split())

array = list(map(int, input().split()))

# custom binary search
def binary_search(array, start, end, target):
    result = 0
    while start <= end:
        # 절단기로 잘라내고 나온 떡 길이의 총합
        total = 0
        mid = (start + end) // 2

        for item in array:
            if item > mid:
                total += item - mid
        
        # 총합이 목표보다 크거나 같으면 우선 해당 총합을 만든 mid지점은 정답의 후보가 되며, 더 작은 값을 만들기 위한 division 수행
        # 더 작은 값을 만들기 위해서는 잘라낼 mid값을 키워야 함, 따라서 start = mid + 1
        if total >= target:
            result = mid
            start = mid + 1
        
        # 반대로 총합이 목표보다 작다면 해당 총합을 만든 mid지점은 유효한 정답이 되지 않으며, 더 큰 값을 만들기 위한 division 수행
        # 더 큰 값을 만들기 위해서는 잘라낼 mid 값을 줄여야 함, 따라서 end = mid - 1
        else:
            end = mid - 1
    
    return result

start = 0
end = max(array)
print(binary_search(array, start, end, m))
