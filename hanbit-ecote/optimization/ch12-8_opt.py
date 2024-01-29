# p.322 문자열 정렬 OPT based on solution
# isalpha() 활용, exception handling 대체
# sum = 0인 경우도 고려

string = input()
result = []
sum = 0

for x in string:
    # isaplha(): checks char
    if x.isalpha():
        result.append(x)
    # add ints
    else:
        sum += int(x)

result.sort()

# don't append if no ints are in string
if sum != 0:
    result.append(str(sum))

print(''.join(result))