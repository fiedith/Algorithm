def solution(p):
    # 1. 빈 문자열이라면 빈 문자열 반환
    if p == '':
        return ''
    
    # 2. 문자열 p를 u, v로 분리
    u = ''
    v = ''
    arr = list(p)
    opening = 0
    closing = 0

    for i in range(len(arr)):
        if arr[i] == '(':
            opening += 1
        else:
            closing += 1
        if opening == closing:
            for letter in arr[0 : i+1]:
                u += letter
            for letter in arr[i+1 : len(arr) + 1]:
                v += letter
            break
    
    # 3. u가 올바르다면 문자열 v에 대해 1단계부터 재귀수행 후 u에 이어 붙인다
    if u[0] == '(':
        return u + solution(v)
    # 4. u가 올바르지 않다면 아래 과정을 수행
    else:
        str = '('
        str += solution(v)
        str += ')'
        u_list = list(u)
        u_list.pop(0)
        u_list.pop()
        for item in u_list:
            if item == '(':
                str += ")"
            else:
                str += "("
        return str