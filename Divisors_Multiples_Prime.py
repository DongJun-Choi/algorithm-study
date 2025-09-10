# 5086
# 첫번째 숫자가 2번째 수의 약수면 factor, 배수면 multiple 둘다 아니면 neither

# c = True
# answer = []

# while c:
#     a, b = map(int, input().split())
#     if a == 0:
#         c = False
#         break
#     if a < b and b % a == 0:
#         answer.append("factor")
#     elif b < a and a % b == 0:
#         answer.append("multiple")
#     else:
#         answer.append("neither")

# print("\n".join(answer))


# 2501
# N
# K는 N의 약수들 중 K번째로 작은 수

# N, K = map(int, input().split())

# num = []

# for i in range(N):
#     if N % (i+1) == 0:
#         num.append(i+1)

# if K > len(num):
#     print(0)
# else:
#     print(num[K-1])