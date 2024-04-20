# p.321 럭키 스트레이트

input = list(input())
score = [int(num) for num in input]

mid = len(score) // 2
left_scores = score[0:mid]
right_scores = score[mid:len(score)]

if sum(left_scores) == sum(right_scores):
    print("LUCKY")
else:
    print("READY")