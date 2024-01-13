# recursive binary search
def binary_search(array, target, start, end):
    # target value not found in array
    if start > end:
        return None
    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    
    # if mid value > target value, set endpoint to left of mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    
    # if mid value < target value, set startpoint to right of mid
    else:
        return binary_search(array, target, mid+1, end)
    
# view start

# array size, target value
n, target = map(int, input().split())

array = list(map(int, input().split()))

result = binary_search(array, target, 0, n-1)
if result == None:
    print("none")
else:
    print("target at", result + 1)