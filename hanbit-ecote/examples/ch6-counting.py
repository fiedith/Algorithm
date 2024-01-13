# suppose all elements in array are positive integers
array = [1, 10, 5, 3, 7, 6, 6, 5]

# array에서 가장 큰 값을 기준으로 counting_list의 크기가 결정된다
counting_list = [0] * (max(array) + 1)

for i in range(len(array)):
	counting_list[array[i]] += 1

for i in range(len(counting_list)):
	for j in range(counting_list[i]):
		print(i, end=" ")