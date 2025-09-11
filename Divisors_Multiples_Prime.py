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


# 9506
# n과 n의 모든 약수를 더한 값이 같으면 완전수, 아니면 n is NOT perfect.

# results = []

# while True:
#     N = int(input())
#     if N == -1:
#         break

#     num = []
#     for i in range(1, N):
#         if N % i == 0:
#             num.append(i)

#     if N == sum(num):
#         results.append(f"{N} = " + " + ".join(map(str, num)))
#     else:
#         results.append(f"{N} is NOT perfect.")

# for line in results:
#     print(line)


# 1978
# 처음에 개수 N 주어지고 N개 만큼 값이 들어옴
# 들어온 값 중에 소수가 몇개인지 찾기
# 소수 찾는법?

# def is_prime(n):
#     if n < 2:
#         return False
#     for i in range(2, n):
#         if n % i == 0:
#             return False
#     return True

# N = int(input())
# num = list(map(int, input().split()))
# count = 0

# for i in num:
#     if is_prime(i):
#         count += 1

# print(count)