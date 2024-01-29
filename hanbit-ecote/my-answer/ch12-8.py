# p.322 문자열 재정렬

string = input()
string = list(string)

# sorts int followed by strings
string.sort()

sum = 0

while True:
    # break if not intable
    try:
        int_value = int(string[0])
    except ValueError:
        break

    # pop int and add to sum
    sum += int(string.pop(0))

result = ''.join(string)
print(result + str(sum))