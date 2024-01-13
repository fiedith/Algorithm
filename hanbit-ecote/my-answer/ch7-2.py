# p.197 부품 찾기
# 접근 방법: binary search

def binary_search(array, start, end, target):
    if start > end:
        return False
    mid = (start + end) // 2

    if array[mid] == target:
        return True
    
    elif array[mid] > target:
        return binary_search(array, start, mid - 1, target)
    
    else:
        return binary_search(array, mid + 1, end, target)

n = int(input())
n_parts = list(map(int, input().split()))

m = int(input())
m_parts = list(map(int, input().split()))

# sort n_parts
n_parts = sorted(n_parts)

for i in range(m):
    target = m_parts[i]
    result = binary_search(n_parts, 0, n-1, target)

    if result:
        print("yes", end = " ")
    else:
        print("no", end = " ")
