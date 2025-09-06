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