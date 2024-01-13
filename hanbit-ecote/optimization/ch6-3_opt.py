# p.180 성적 낮은 학생 순서대로 출력
# tuple과 sorted() 사용

n = int(input())

array = []

for i in range(n):
    input_data = input().split()
    # append to list as tuple data
    array.append((input_data[0], input_data[1]))

# sort by score values
array = sorted(array, key=lambda student:student[1])

for student in array:
    print(student[0], end=' ')