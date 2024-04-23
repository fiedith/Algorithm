def rotate_90_degrees(graph):
	rows = len(graph)   # 행 길이
	cols = len(graph[0])   # 열 길이
	result = [[0] * rows for _ in range(cols)]   # 결과 리스트
	for i in range(rows):
		for j in range(cols):
			result[j][rows - i - 1] = graph[i][j]
	return result


def check(new_lock):
	# param으로 주어지는 lock은 길이가 3배짜리인 그래프임
	lock_length = len(new_lock) // 3
	for i in range(lock_length, lock_length * 2):
		for j in range(lock_length, lock_length * 2):
			if new_lock[i][j] != 1:
				return False    # 돌기가 서로 안맞거나 비어있는 공간이 있는 경우 거기에 보관
	return True

def solution(key, lock):
	lock_length = len(lock)     # 원본 자물쇠의 길이
	key_length = len(key)       # 키의 길이
	
    # 3배로 늘리고 정중앙에 기존의 lock 배치
	new_lock = [[0] * (lock_length * 3) for _ in range(lock_length * 3)]
	for i in range(lock_length):
		for j in range(lock_length):
			new_lock[lock_length + i][lock_length + j] = lock[i][j]
			
    # 4번의 회전
	for _ in range(4):
		key = rotate_90_degrees(key)
		# 0 ~ lock의 2배치만큼의 위치로 해야 new_lock에 키를 맞춰볼 수 있다
		for x in range(lock_length * 2):
			for y in range(lock_length * 2):
				# 키의 모든 원소들을 하나씩 확인해서 New_lock에 값을 더한다
				for i in range(key_length):
					for j in range(key_length):
						new_lock[x + i][y + j] += key[i][j]
				# 만약 완벽히 들어맞는다면 종료 (즉 비어있는 곳이 없거나 자물쇠 돌기와 겹쳐지는 영역이 존재한다면)
				if check(new_lock):
					return True
				# 위에서 return이 안됐다면 이는 정답이 아니므로 다시 키의 모든 원소들을 확인하며 더한 만큼 다시 뺴서 원복
				for i in range(key_length):
					for j in range(key_length):
						new_lock[x + i][y + j] -= key[i][j]
    # 만약 위 과정에서 True가 한번도 안된 경우는 맞지 않는 것임
	return False