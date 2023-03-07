import sys

# sys.stdin = open("in1.txt", "rt")

N = int(sys.stdin.readline())
m = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

###리스트 가장자리 0으로 채우기 (난 사용X) ->> 0채우고 all 함수 사용하는거 cool
# m.insert(0,[0]*N)
# m.append([0]*N)
# for x in m:
#     x.insert(0,0)
#     x.append(0)
# for i in range(1, N+1):
#     for j in range(1, N+1):
#         if (all([i][j] > a[i+dx[k]][i+dy[k]] for k in range(4)):
#             res+=1
###




#왼 위 오 아래
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

res=0

for i in range(N):
    for j in range(N):
        
        for k in range(4):
            nx = i+dx[k]
            ny = j+dy[k]

            if (0 > nx or nx >= N or 0 > ny or ny >= N):
                continue
            else:
                if (m[nx][ny] >= m[i][j]):
                    break
        else:
            res+=1

print(res)
