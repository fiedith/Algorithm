# p.325 자물쇠와 열쇠
# https://school.programmers.co.kr/learn/courses/30/lessons/60059
# brute force

# rotate 2d list by 90 degrees
def rotate_maxtix_by_90_degree(a):
    n = len(a)      # row len
    m = len(a[0])   # col len
    result = [[0] * n for _ in range(m)]    # result list
    for i in range(n):
        for j in range(m):
            result[j][n - i - 1] = a[i][j]
    
    return result

# 자물쇠의 중간 부분이 모두 1인지 확인
# @param 3배크기 배열
# @return boolean
def check(new_lock):
    # param new_lock은 원본 lock의 3배 크기로 늘린 matrix이므로 원본 길이는 1/3
    lock_length = len(new_lock) // 3

    # param new_lock의 원본 길이 ~ 원본 길이 * 2 지점이 현재 원본 matrix의 위치이기 때문
    for i in range(lock_length, lock_length * 2):
        for j in range(lock_length, lock_length * 2):
            if new_lock[i][j] != 1:
                return False
    return True

def solution(key, lock):
    lock_len = len(lock)
    key_len = len(key)

    # 자물쇠 크기를 기존의 3배로 변환
    new_lock = [[0] * (n * 3) for _ in range(n * 3)]

    # 3배로 확장된 자물쇠 중앙에 원본 자물쇠 넣기
    for i in range(lock_len):
        for j in range(lock_len):
            new_lock[i + lock_len][j + lock_len] = lock[i][j]
    
    # 4 방향 전부 확인
    for rotation in range(4):
        key = rotate_maxtix_by_90_degree(key)   # 열쇠 회전
        for x in range(lock_len * 2):
            for y in range(lock_len * 2):
                # 자물쇠에 열쇠 끼우기
                    for i in range(key_len):
                        for j in range(key_len):
                            new_lock[x + i][y + i] += key[i][j]
                    # 열쇠가 맞는지 확인
                    if check(new_lock) == True:
                        return True
                    # 열쇠가 맞는지 확인한 후 안맞다면, 맞춰보면서 더한 값만큼 뺴줘서 원상복구
                    for i in range(lock_len):
                        for j in range(lock_len):
                            new_lock[x + i][y + i] -= key[i][j]
    
    # 4방향 전부 확인 후 True반환이 안됐다면 맞는 것이 하나도 없다
    return False
