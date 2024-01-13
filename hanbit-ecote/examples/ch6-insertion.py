# p.161 insertion sort
# 각 위치에 존재하는 값들을 적절한 위치에 삽입시키는 방식

array = [2, 4, 1, 3, 5, 7, 6, 8, 9, 0]

# insertion sort
for i in range(1, len(array)):
	for j in range(i, 0, -1):
		# 인접한 두 값이 내림차순으로 되어있다면 두 값을 swap
		if array[j] < array[j-1]:
			array[j], array[j-1] = array[j-1], array[j]
		# 효율성
		else:
			break
		
print(array)