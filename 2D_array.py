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