# p.322 문자열 재정렬

s = list(input())
s.sort()

result_list = []
total = 0

for item in (s):
    if ord(item) < ord('A'):
        total += int(item)
        continue
    result_list.append(item)

string = ''.join(result_list)

# prevent from printing 0
if total == 0:
    print(string)
else:
    print(string + str(total))