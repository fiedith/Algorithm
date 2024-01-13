# p.180 성적이 낮은 순서로 학생 출력하기
# selection sort를 이용했으나 개선이 필요함

n = int(input())

array = []

# 입력 
for i in range(n):
    array.append(list(input().split()))

# 정렬
for i in range(n):
    min_idx = i
    for j in range(i, n):
       if array[j][1] < array[min_idx][1]:
            min_idx = j
    array[min_idx], array[i] = array[i], array[min_idx]


for i in range(n):
    print(array[i][0], end=' ')
