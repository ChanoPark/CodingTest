def search(position, a, b, M, N):
    dx = [-1, 0, 1, 0] #왼, 위, 오, 아래
    dy = [0, 1, 0, -1]

    for i in range(0,4):
        nx = a+dx[i]
        ny = b+dy[i]

        if(nx < 0 or nx >= M or ny < 0 or ny >= N):
            continue
        else:
            if(position[ny][nx]==1):
                position[ny][nx]=0
                search(position,nx,ny,M,N)

    return position

TC = int(input())
result = []

for i in range(TC):
    M, N, K = map(int, input().split())
    position = [[0 for row in range(M)] for col in range(N)]
    
    for j in range(K):
        x, y = map(int, input().split())
        position[y][x] = 1

    worm=0
    for a in range(M):
        for b in range(N):
            if(position[b][a] == 1):
                position[b][a]=0
                search(position, a, b, M, N)
                worm+=1
    result.append(worm)

for cnt in range(len(result)):
    print(result[cnt])