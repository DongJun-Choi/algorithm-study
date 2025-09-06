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


