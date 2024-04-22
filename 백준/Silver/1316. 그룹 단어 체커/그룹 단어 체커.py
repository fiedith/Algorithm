# return boolean
def is_group(string):
	letters = list(string)
	while letters:
		popped = letters.pop(0)
		if popped in letters and letters[0] != popped:
			return False
	return True

n = int(input())
answer = 0

for i in range(n):
	string = input()
	if(is_group(string)):
		answer += 1

print(answer)