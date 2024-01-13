# p. 157 selection sort
# 배열에서 가장 작은 값을 구해 맨 앞 인덱스 요소와 swap

array = [2, 4, 1, 3, 5, 7, 6, 8, 9, 0]


for i in range(len(array)):
    # 가장 작은 값을 가진 원소의 인덱스
    min_index = i
    for j in range(i + 1, len(array)):
        if array[j] < array[min_index]:
            min_index = j
    # swap
    array[i], array[min_index] = array[min_index], array[i]

print(array)