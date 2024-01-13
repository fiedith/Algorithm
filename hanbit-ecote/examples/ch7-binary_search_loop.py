def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        
        # if target is found
        if array[mid] == target:
            return mid
        
        # search the left side if target is below mid
        elif array[mid] > target:
            end = mid - 1
        
        # search the right side if target is above mid
        else:
            start = mid + 1
        
    return None

# view start

n, target = map(int, input().split())
array = list(map(int, input().split()))

result = binary_search(array, target, 0, n-1)
if result == None:
    print("none")
else:
    print("target at", result + 1)