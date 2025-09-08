# 2745
# N을 주고 B진법을 준다
# 10진법으로 변환해서 값을 출력한다
# 어떻게 해야할까? 일단 각 자리 숫자 + (진법수^자리수)로 10진법이 표현됨
# ex: ZZZZZ 36이면 Z는 1*(36^0) + 10*(36^1) + 100(36^2) ... 이런식으로

# N, B = input().split()
# B = int(B)

# sum = 0
# num = len(N) - 1

# for i in N:
#     if '0' <= i <= '9':
#         sum += (ord(i) - ord('0')) * (B ** num)
#     else:
#         sum += (ord(i) - ord('A')+10) * (B ** num)
#     num -= 1

# print(sum)