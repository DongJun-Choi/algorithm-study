# 2738
# 처음에 주는 두 수는 N, M으로 행렬의 크키 N*M이 주어지고
# 다음에 2개의 행렬이 온다 행렬을 다 더 저장하고 
# 그 행렬들을 더해야하는데 반복 횟수는 N*M만 하면 될듯?

# N, M = map(int, input().split())

# A = [[0]*M for _ in range(N)]
# B = [[0]*M for _ in range(N)]
# total = [[0]*M for _ in range(N)]

# for i in range(N):
#     test = list(map(int, input().split()))
#     for j in range(M):
#         A[i][j] = test[j]

# for i in range(N):
#     test = list(map(int, input().split()))
#     for j in range(M):
#         B[i][j] = test[j]

# for i in range(N):
#     for j in range(M):
#         total[i][j] = A[i][j]+B[i][j]

# for row in total:
#     print(*row)


# 2566
# 9*9 2차원 배열에서 최댓값 찾기
# 최댓값을 찾으면서 최댓값 갱신될때마다 위치랑 최댓값 값 증가

# A_max = 0
# max_locate = [0]*2

# for i in range(9):
#     test = list(map(int, input().split()))
#     for j in range(9):
#         if A_max <= test[j]:
#             A_max = test[j]
#             max_locate[0] = i+1
#             max_locate[1] = j+1

# print(A_max)
# print(max_locate[0], max_locate[1])


# 10798
# 걍 5*5 행렬에서 행으로 읽는게 아니라 열로 읽는 문제인듯?
# 한줄의 단어는 최대 15네
# 특이점: 공백 없이 들어옴, 3줄안에 5개가 무조건 존재하는 것 아닐 수 있음

# A = [['']*15 for _ in range(5)]

# for i in range(5):
#     test = list(input())
#     for j in range(len(test)):
#         A[i][j] = test[j]

# for j in range(15):
#     for i in range(5):
#         if A[i][j] != '':
#             print(A[i][j], end = '')


# 2563
# 100*100 도화지가 존재하고
# 10*10 색종이가 여러개 평행해서 붙인다. 그리고 색종이의 넓이를 구하는 프로그램
# 첫줄은 색종이 수
# 나머지는 왼쪽 아래 점의 좌표값으로 제공

# 겹치는 부분을 구해서 색종이 전체 넓이에서 - 겹치는 부분을 해서 풀면될듯?
# 겹치는 부분을 구할려면? 처음 좌표 준 좌표와 그 좌표에 +10씩 한 좌표 이내에 겹치는지 확인후
# 이런식으로 진행하면 너무 복잡해짐. 2장이 겹치는 건 계산 가능하지만 3장 이상부터는 너무 힘듬

# 차라리 2차원 배열을 0으로 채우고, 색종기 부분만 1로 채우고 다 더하면 넓이가 됨

# n = int(input())
# black = [[0]*100 for _ in range(100)]


# for _ in range(n):
#     x, y = map(int, input().split())
#     for i in range(x, x+10):
#         for j in range(y, y+10):
#             black[i][j] = 1

# area = 0
# for i in range(100):
#     area += sum(black[i])

# print(area)


# 초기 내 아이디어를 gpt를 통하여 코드로 구현, 문제 통과함
# 근본적으로는 검은색들만 모아서 넓이는 구하는 것은 똑같음

# import sys

# input = sys.stdin.readline

# n = int(input())
# rects = [tuple(map(int, input().split())) for _ in range(n)]

# # 이벤트: (x, type, y1, y2)  type=+1(시작), -1(끝)
# events = []
# for x, y in rects:
#     events.append((x, +1, y, y + 10))
#     events.append((x + 10, -1, y, y + 10))

# # x 기준 정렬
# events.sort()

# active = []  # 활성 y-구간들 (y1, y2)들을 다 넣어둠 (중복 허용)
# area = 0
# prev_x = events[0][0] if events else 0

# def union_length(intervals):
#     """여러 [y1,y2) 구간의 합집합 길이"""
#     if not intervals:
#         return 0
#     intervals = sorted(intervals)  # y1 기준
#     total = 0
#     cur_s, cur_e = intervals[0]
#     for s, e in intervals[1:]:
#         if s <= cur_e:        # 겹치거나 맞닿음
#             if e > cur_e:
#                 cur_e = e
#         else:                  # 분리
#             total += cur_e - cur_s
#             cur_s, cur_e = s, e
#     total += cur_e - cur_s
#     return total

# i = 0
# m = len(events)
# while i < m:
#     x = events[i][0]
#     # 직전 x~현재 x까지 면적 누적
#     dx = x - prev_x
#     if dx > 0:
#         ly = union_length(active)
#         area += dx * ly
#         prev_x = x

#     # 같은 x에 있는 이벤트들을 한 번에 처리
#     while i < m and events[i][0] == x:
#         _, typ, y1, y2 = events[i]
#         if typ == +1:
#             active.append((y1, y2))
#         else:
#             # 같은 (y1,y2) 하나 제거 (중복 가능성 있으니 첫 매치만 제거)
#             for k in range(len(active)):
#                 if active[k] == (y1, y2):
#                     active.pop(k)
#                     break
#         i += 1

# print(area)