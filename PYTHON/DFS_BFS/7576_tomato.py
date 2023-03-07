from collections import deque

def BFS(M, N):
    while(queue):
        x, y = queue.popleft()
        for i in range(4):
            dx = x + DX[i]
            dy = y + DY[i]
            if(0 <= dx < M and 0 <= dy < N and box[dy][dx]==0):
                box[dy][dx]=box[y][x]+1
                queue.append([dx,dy])

M, N = map(int, input().split())
box = [[]*M for _ in range(N)]
queue = deque()
day=0

for i in range(N):
    box[i] = list(map(int, input().split()))

for j in range(N):
    for k in range(M):
        if (box[j][k]==1):
            queue.append([k,j])

DX = [-1, 1, 0, 0] #왼 오 앞 뒤
DY = [0, 0, 1, -1]

BFS(M, N)

for i in box:
    for j in i:
        if(j==0):
            print(-1)
            exit(0)
    day=max(day,max(i))

print(day-1)