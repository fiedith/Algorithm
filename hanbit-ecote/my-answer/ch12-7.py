# p.321 럭키 스트레이트

score = input()
score_list = list(map(int, str(score)))
divider = len(score_list) // 2

right = 0
left = 0
for i in range(0, divider):
    right += score_list[i]

for j in range(divider, len(score_list)):
    left += score_list[j]

if right == left:
    print("LUCKY")
else:
    print("READY")