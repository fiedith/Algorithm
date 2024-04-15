# n strings, m brands
n, m = map(int, input().split())

packages = []
ones = []

for i in range(m):
    package, one = map(int, input().split())
    packages.append(package)
    ones.append(one)

# 낱개 최소 가격
min_ones = min(ones)
packages.append(6 * min_ones)

# 패키지 최소 가격
min_packages = min(packages)

# 구매 필요한 패키지 수
req_packages = n // 6

# 구매 필요한 낱개 수
req_ones = n % 6

package_price = min_packages * req_packages

# 낱개로만 사는 경우와 패키지 하나를 구매하는 경우를 비교하고 더 낮은 값으로 설정
ones_price = min(min_ones * req_ones, min_packages)

answer = package_price + ones_price
print(answer)