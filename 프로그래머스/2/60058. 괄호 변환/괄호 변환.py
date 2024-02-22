# @param string
# @return int
def balanced_index(p):
    open_counter = 0
    close_counter = 0
    for i in range(len(p)):
        if p[i] == '(':
            open_counter += 1
        else:
            close_counter += 1
        if open_counter == close_counter:
            return i    # 여는 괄호와 닫는 괄호가 일치하는 시점이 올바른 문자열의 index

# @param string
# @return boolean
def check_proper(p):
    counter = 0     # 여는 괄호의 개수
    for i in range(len(p)):
        if p[i] == '(':
            counter += 1
        else:
            if counter == 0:    # 닫는 괄호로 시작하는 경우 이는 무조건 올바른 문자열이 아님
                return False
            counter -= 1
    return True

def solution(p):
    answer = ''
    # 빈 문자열은 있는 그대로 반환하는 조건이자 재귀함수 종료 조건
    if p == '':
        return ''
    index = balanced_index(p)   # 문자열에서 최초로 균형 잡힌 시점을 기준으로 u, v로 나눈다
    u = p[:index + 1]
    v = p[index + 1:]
    
    # 조건: u가 올바르면 v를 재귀실행하고 결과를 뒤이어 붙인다.
    if check_proper(u):
        answer = u
        answer += solution(v)
    # 조건: u가 올바르지 않다면 조건을 따른다.
    else:
        answer = '('
        answer += solution(v)
        answer += ')'
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == '(':
                u[i] = ')'
            else:
                u[i] = '('
        answer += "".join(u)
    return answer