# 25083
# print("         ,r'\"7")
# print("r`-_   ,'  ,/")
# print(" \. \". L_r'")
# print("   `~\/")
# print("      |")
# print("      |")

# 3003
# a = list(map(int, input().split()))
# b = [1, 1, 2, 2, 2, 8]
# result = []
# for i in range(6):
#     result.append(b[i]-a[i])
# print(*result)

# 2444
# a = int(input())
# for i in range(a):
#     for j in range(a - i - 1):
#         print(" ", end="")
#     for j in range(2 * i + 1):
#         print("*", end="")
#     print()
# for i in range(1, a):
#     for j in range(i):
#         print(" ", end="")
#     for j in range(2 * (a - i - 1) + 1):
#         print("*", end="")
#     print()

# 10988
# a = list(input())
# b = list(reversed(a))
# found = 0
# for i in range(len(a)):
#     if a[i] != b[i]:
#         print(0)
#         found = 1
#         break
# if(found == 0):
#     print(1)

# 1157
# a = list(input().upper())
# b = [0]*26
# for ch in a:
#     if 'A' <= ch <= 'Z':
#         index = ord(ch) - ord('A')
#         b[index] += 1
# max_count = max(b)
# if b.count(max_count) > 1:
#     print("?")
# else :
#     print(chr(b.index(max_count) + ord('A')))

# 2941(크로아티아 알파벳을 그냥 한단어로 치환)
# word = input()
# croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
# for c in croatia:
#     word = word.replace(c, '*')  # 크로아티아 알파벳 하나를 *로 치환
# print(len(word))
# 2941(직접 크로아티아 알파벳 필터링)
# a = input()
# i = 0
# count = 0
# while i < len(a):
#     if i+2 < len(a) and a[i:i+3] == 'dz=':
#         count += 1
#         i += 3
#     elif i+1 < len(a) and a[i:i+2] in ['c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']:
#         count += 1
#         i += 2
#     else:
#         count += 1
#         i += 1
# print(count)

# 1316
# 알파벳 배열을 만든 다음에 단어를 체크를 할 때 첫 알파벳은 그냥 넣고 
# 다음에 다른 알파벳이 올 경우 단어의 알파벳이 배열에 카운팅 되어있는지 확인 후
# 알파벳 배열에 추가, 만약 이미 카운팅 되어있다면 그룹단어 x
# a = int(input())
# for _ in range(a):
#     b = input()



# 동적

# 24416
# n이 1 or 2면 return
# fib(5-1) + fib(5- 2)
# 5 => 4, 3
# 4 => 3, 2
# 3 => 2, 1

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

def w(a, b, c): 
    if a <= 0 or b <= 0 or c <= 0 : 
        return 1

    if a > 20 or b > 20 or c > 20 :
        return w(20, 20, 20)

    if a < b and b < c :
        return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

    return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

user_input = list(map(int, input().split()))
a, b, c = user_input
result = w(a, b, c)
print(f"w({a}, {b}, {c}) = {result}")
