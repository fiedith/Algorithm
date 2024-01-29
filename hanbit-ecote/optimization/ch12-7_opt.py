# p.321 럭키 스트레이트 OPT
# 별도 list 사용 불필요 및 변수 최소화, 비교 접근 방식 변화

score = input()
length = len(score)
result = 0

for i in range(length // 2):
    result += int(score[i])

for i in range(length//2 , length):
    result -= int(score[i])

if result == 0:
    print("LUCKY")
else:
    print("READY")