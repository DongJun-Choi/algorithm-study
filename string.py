# 27866
# a = input()
# n = int(input())
# print(a[n-1])

# 2743
# a = input()
# print(len(a))

# 9086
# a = int(input())
# for _ in range(a):
#     s = input()
#     print(s[0] + s[-1])

# 11654
# a = input()
# print(ord(a))
# ord() = returns the Unicode code point of a character

# 11720
# a = input()
# b = input()
# print(sum(map(int, b)))

# 10809
# a = input()
# s = []
# for _ in range(26):
#     s.append(a.find(chr(97 + _)))
# print(*s)

# 2675
# a = int(input())
# for _ in range(a):
#     b, c = input().split()
#     b = int(b)
#     for i in range(len(c)):
#         for j in range(b):
#             print(c[i], end="")
#     print()

# 1152
# a = input().split()
# print(len(a))

# 2908
# a = input().split()
# b = []
# for i in a:
#     b.append(i[::-1])
# print(max(b))

# 5622
# a = list(input())
# b = []
# for i in a:
#     if (i == 'A' or i == 'B' or i == 'C'):
#         b.append(3)
#     if (i == 'D' or i == 'E' or i == 'F'):
#         b.append(4)
#     if (i == 'G' or i == 'H' or i == 'I'):
#         b.append(5)
#     if (i == 'J' or i == 'K' or i == 'L'):
#         b.append(6)
#     if (i == 'M' or i == 'N' or i == 'O'):
#         b.append(7)
#     if (i == 'P' or i == 'Q' or i == 'R' or i == 'S'):
#         b.append(8)
#     if (i == 'T' or i == 'U' or i == 'V'):
#         b.append(9)
#     if (i == 'W' or i == 'X' or i == 'Y' or i == 'Z'):
#         b.append(10)
# print(sum(b))

# 11718
# import sys
# for line in sys.stdin:
#     print(line, end='')