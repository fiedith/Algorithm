# p.197 부품 찾기
# 접근 방법: counting sort

n = int(input())
# 모든 원소의 번호를 포함할 수 있는 크기의 리스트 생성
array = [0] * 1000001

# 부품 번호들을 입력받고 array에서 해당 번호 인덱스 위치에 마킹
for i in input().split():
    array[int(i)] = 1

# 손님의 요청 부품 개수
m = int(input())
m_list = list(map(int, input().split()))

# 손님이 요청한 부품이 있는지 array에 마킹 유무에 따라 확인
for part in m_list:
    if array[i] == 1:
        print("yes", end = " ")
    else:
        print("no", end = " ")
