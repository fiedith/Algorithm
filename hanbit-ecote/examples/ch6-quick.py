# p.164 quick sort
# pivot 값을 기준으로 배열에서 왼쪽부터 큰 값을 -> 방향으로 탐색, 오른쪽부터 작은 값을 <- 방향으로 탐색하는 방식. 그 후 divide and conquer. 

array = [2, 4, 1, 3, 5, 7, 6, 8, 9, 0]

# args: array, starting index, ending index
def quick_sort(array, start, end):
    # end if array consists of 1 (or less) element
    if start >= end:
        return
    # set pivot as starting index
    pivot = start
    left = start + 1
    right = end

    # index 값이 오른쪽이 더 큰 동안, 즉 left와 right가 cross되기까지
    while left <= right:
        # 왼쪽 탐색이 끝지점을 만나기 전, 그리고 pivot 값이 왼쪽 탐색 값보다 큰 경우 계속 탐색
        while left <= end and array[left] <= array[pivot]:
            left += 1
        
        # 오른쪽 탐색이 시작지점을 만나기 전, 그리고 pivot값이 오른쪽 탐색 값보다 작은 경우 계속 탐색
        while right > start and array[right] >= array[pivot]:
            right -= 1
        
        # 엇갈린 경우, 오른쪽 탐색 값과 pivot 위치를 swap
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        # 엇갈리지 않은 경우, 왼쪽 탐색 값과 오른쪽 탐색 위치를 swap
        else:
            array[left], array[right] = array[right], array[left]
    
    # divide and conquer: 현재 뒤바뀐 pivot 위치를 기준으로 양 옆 위치들 대상으로 recursive quick sort
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array) - 1)
print(array)