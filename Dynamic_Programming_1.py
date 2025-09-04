# 24416
# n이 1 or 2면 return
# fib(5-1) + fib(5-2)
# 재귀함수를 넣으니 python에서는 시간초과가 됨.
# fib()의 카운팅 값은 피보나치 수열의 값이기 때문에 동적 계획법 함수만으로 값을 구할 수 있음.

# count1 = 0
# def fib(n):
#     global count1
    
#     if n <= 2:
#         count1 += 1
#         return 1
#     else:
#         return fib(n - 1) + fib(n - 2)

# count2 = 0

# def fibonacci(n):
#     global count2

#     if n <= 2:
#         return 1

#     f = [0] * (n + 1)
#     f[1] = 1
#     f[2] = 1

#     for i in range(3, n + 1):
#         f[i] = f[i-1] + f[i-2]
#         count2 += 1
    
#     return f[n]

# a = int(input())
# result = fibonacci(a)
# print(result, count2)


# 9184
# 값들을 저장해서 그 값들을 꺼내서 더해서 사용하여 중복 계산 막기
# 그렇다면 저 재귀 함수의 값들을 새롭게 계속 호출하는 것이 아닌 값을 배열에 저장해서
# 재사용을 해야할듯?
# 재사용을 위해서는 값 저장할 배열 생성 필요, 배열은 3개의 값 저장할 3차원
# 이제 값 저장하고 배열에 값이 있을 경우에는 값을 가져와서 사용

# dp = [[[0] * 21 for _ in range(21)] for _ in range(21)]

# def w(a, b, c): 

#     if a <= 0 or b <= 0 or c <= 0 : 
#         return 1

#     if a > 20 or b > 20 or c > 20 :
#         return w(20, 20, 20)
    
#     if dp[a][b][c] != 0:
#         return dp[a][b][c]

#     if a < b and b < c :
#         dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
#     else :
#         dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

#     return dp[a][b][c]

# while True:
#     user_input = list(map(int, input().split()))
#     a, b, c = user_input
#     result = w(a, b, c)
#     if a == -1 and b == -1 and c == -1 :
#         break
#     else :
#         print(f"w({a}, {b}, {c}) = {result}")
