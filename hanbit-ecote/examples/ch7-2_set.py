# p.197 부품 찾기
# 접근 방식: set

# 가게의 부품 개수
n = int(input())

# 가게의 부품 번호들을 set에 기록
array = set(map(int, input().split()))

# 손님이 찾을 부품 개수
m = int(input())
m_list = list(map(int, input().split()))

for part in m_list:
    if part in m_list:
        print("yes", end = " ")
    else:
        print("no", end = " ")