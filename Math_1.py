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


# 11005
# 10진수 N을 주고 B진법을 준다
# N을 B진법으로 바꿔서 출력
# N / B하고 남은 걸 계속 진행해서 못 나누면 그게 1의 자리

# N, B = map(int, input().split())

# num = ''

# while N > 0:
#     remain = N % B
#     if remain < 10:
#         num = str(remain) + num
#     else:
#         num = chr(ord('A') + remain - 10) + num
#     N = N // B

# print(num)


# 2720
# 거스름돈 문제로 처음에 케이스 수(T)를 주고
# 거스름돈 C(1<=C<=500 센트)를 주면 
# 그걸 0.25 = 25, 0.10 = 10, 0.05 = 5, 0.01 = 1의 동전을 최소한으로 넘겨주고 그 수를 출력
# 1달러 = 100센트

# T = int(input())
# remain = []

# for _ in range(T):
#     Q = 0
#     D = 0
#     N = 0
#     P = 0

#     C = int(input())
#     Q = C // 25
#     C = C % 25
#     D = C // 10
#     C = C % 10
#     N = C // 5
#     C = C % 5
#     P = C
#     remain.append(f"{Q} {D} {N} {P}")

# print("\n".join(remain))