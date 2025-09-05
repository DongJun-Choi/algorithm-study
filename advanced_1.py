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

# count = 0
# n = int(input())

# for _ in range(n):
#     b = input()
#     a = [0]*26
#     prev = ''
#     flag = True

#     for i in b:
#         idx = ord(i) - ord('a')
#         if i != prev :
#             if a[idx] == 1:
#                 flag = False
#                 break                
#             a[idx] = 1
#             prev = i

#     if flag:
#         count += 1  # 그룹 단어일 때만 증가

# print(count)


# 25206
# 전공 평점 계싼해주는 문제
# 입력 방식은 문자열, 공백, 학점, 공백, A+로 되어있는 것이 20줄로 들어옴
# 여기서 학점만 가져와야하는데 만약 등급이 P or F로 되어 있으면 전공평점 계산에서 제외
# 전공 평점 계산식은 학점*과목평점의 합을 학점의 총 합으로 나누기
# a+ : 4.5 ~ D0 : 1.0, F : 0.0

# sum = 0
# score = 0

# for _ in range(20):
#     a = input().split()
#     if(a[2] == 'A+'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*4.5)
#     elif(a[2] == 'A0'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*4)
#     elif(a[2] == 'B+'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*3.5)
#     elif(a[2] == 'B0'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*3)
#     elif(a[2] == 'C+'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*2.5)
#     elif(a[2] == 'C0'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*2)
#     elif(a[2] == 'D+'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*1.5)
#     elif(a[2] == 'D0'):
#         score = score + float(a[1])
#         sum = sum + (float(a[1])*1)
#     elif(a[2] == 'F'):
#         score = score + float(a[1])

# print(sum/score)


