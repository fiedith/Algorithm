# p.329 기둥과 보 설치
# https://school.programmers.co.kr/learn/courses/30/lessons/60061

# 현재 구조물이 가능한 구조물인지 확인
def possible(answer):
    for x, y, stuff in answer:
        # 기둥인 경우
        if stuff == 0:
            # 바닥 위 or 보의 한쪽 끝 위 or 다른 기둥 위 -> 괜찮다
            if y == 0 or [x-1, y, 1] in answer or [x, y, 1] in answer or [x, y-1, 0] in answer:
                continue    # 다음 구조물 탐색
            return False    # 조건에 부합하지 않으면 불가능한 구조물
        # 보인 경우
        elif stuff == 1:
            # 한쪽 끝부분이 기둥의 위 or 양쪽 끝부분이 다른 보와 동시에 연결 -> 괜찮다
            if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer):
                continue    # 다음 구조물 탐색
            return False    # 조건에 부합하지 않으면 불가능한 구조물
    return True


def solution(n, build_frame):
    answer = []

    for frame in build_frame:
        x, y, stuff, operate = frame
        # 삭제하는 경우
        if operate == 0:
            answer.remove([x, y, stuff])    # 일단 삭제하고
            if not possible(answer):        # 가능한 건축이 아니면
                answer.append([x, y, stuff])    # 다시 원상복구
        # 추가하는 경우
        if operate == 1:
            answer.append([x, y, stuff])    # 일단 설치하고
            if not possible(answer):        # 가능한 건축이 아니면
                answer.remove([x, y, stuff])    # 다시 원상복구
    return sorted(answer)