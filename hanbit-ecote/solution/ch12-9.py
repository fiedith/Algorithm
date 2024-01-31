# # p.323 문자열 압축
# https://school.programmers.co.kr/learn/courses/30/lessons/60057

def solution(s):
    answer = len(s)

    # outer loop: 압축 단위 늘리기, step == 단위
    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step]    # 앞에서부터 단위수만큼 문자열 추출
        count = 1   # 압축된 횟수

        # inner loop: 단위만큼 증가시키면서 이전 문자열과 비교하기
        for j in range(step, len(s), step):
            # prev값과 대조 일치시 압축 횟수 증가
            if prev == s[j:j + step]:
                count += 1
            
            # 대조 불일치시 -> 더 이상 압축 못하는 상황
            else:
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j + step]    # 대조 불일치이므로 다음 단위만큼의 문자열이 prev
                count = 1   # 압축 횟수 초기화
        
        # 단위수에 맞지 않는 남은 문자열 처리
        compressed += str(count) + prev if count >= 2 else prev
        # 매 단위별로 가장 짧은 문자열 길이 갱신
        answer = min(answer, len(compressed))

    return answer