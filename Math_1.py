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


# 2903
# 총 점의 수를 구하는데 중복은 포함 안되게
# 초기 4 = 2*2, 1번 3*3, 2번 5*5, 3번? (5*2-1)*(5*2-1)

# N = int(input())

# A = 2

# for i in range(N):
#     A = (A*2-1)

# print(A*A)


# 2292
# 1~7~19~37~61
# 6, 12, 18, 24, 30
# 6씩 증가함

# N = int(input())
# total = 1
# A = 1

# while N > total:
#     N = N - total
#     total = 6*A
#     A += 1

# print(A)


# 1193
# 1, 2, 6, 7, 15, 16
# 1, 3, 4, 10, 11
# 중간에 늘어나는 숫자가 1,2,3,4,5

# 뭔가 느낌이 분자가 크면 다음에도 분자가 커져서 시작하고
# 분모가 크면 분모가 커져서 시작하는 느낌?
# 그리고 중간은 분자 or 분모가 작아지고 분모 or 분자가 커지는 규칙
# A = 해당하는 지그재그의 열이자 행이며 최대 분모이자 분자
# 이제 어디 위치이냐에 따라 A-얼마 / A-얼마 로 나타내면 될듯?
# N-total = 원소의 위치인데 -1을 해줘야함 

# A가 홀수면 분자가 젤 크고 분모가 작음
# A가 짝수면 분모가 젤 크고 분자가 작음


# N = int(input())

# total = 0
# A = 1

# while N > A+total:
#     total = total + A
#     A += 1

# B = N - total -1

# up = 0
# down = 0

# if A % 2 == 0 :
#     up = B + 1
#     down = A - B
# else:
#     up = A - B
#     down = B + 1

# print(f"{up}/{down}")