from collections import deque

def BFS(M, N, H):
    while(queue):
        x, y, z = queue.popleft()
        for j in range(3):
            dz = z + DZ[j]
            if (0 <= dz < H and box[dz][y][x]==0):
                box[dz][y][x]=box[z][y][x]+1
                queue.append([x,y,dz])
        for i in range(4):
            dx = x + DX[i]
            dy = y + DY[i]
            if(0 <= dx < M and 0 <= dy < N and box[z][dy][dx]==0):
                box[z][dy][dx]=box[z][y][x]+1
                queue.append([dx,dy,z])

M, N, H = map(int, input().split())
box = [[[]*M for _ in range(N)] for __ in range(H)]
queue = deque()
day=0

for j in range(H):
    for i in range(N):
        box[j][i] = list(map(int, input().split())) #토마토 정보를 리스트에 추가

for i in range(H): #익은 토마토의 위치정보를 큐에 담는다.
    for j in range(N):
        for k in range(M):
            if (box[i][j][k]==1):
                queue.append([k,j,i])

DX = [-1, 1, 0, 0] #왼 오 앞 뒤
DY = [0, 0, 1, -1]
DZ = [0, -1, 1] # 지금, 아래, 위

BFS(M, N, H)

for k in range(H): #최대값 찾기(정답)
    for i in box[k]:
        for j in i:
            if(j==0):
                print(-1)
                exit(0)
        day=max(day,max(i))

print(day-1) #1부터 시작했으므로 -1