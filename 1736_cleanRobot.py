def check(room, M, N):
    trash = 0
    for i in range(M):
        tmp = 0
        if(max(room[i])<=0):
            room[i] = [-1]*N
            continue
        for j in range(N):
            if(room[i][j] == 1):
                tmp+=1
                trash+=1
            
    print("trash:",trash)
    return trash

M, N = map(int, input().split())

room = [[0 for _ in range(N)] for _ in range(M)]

for i in range(M):
    room[i] = list(map(int, input().split()))
print("room:",room)
robot = 0

while(check(room, M,N)!=0):
    row = 0
    col = 0
    robot+=1
    while(row != M-1 and col != N-1):
        print("row:", row, "col:", col)

        while(room[row][col]==-1):
            row+=1

        if(col==N-1): #맨오른쪽이면
            row+=1
        elif(row==M-1): #맨밑이면
            col+=1
        elif(room[row+1][col] == 1): #밑으로
            room[row+1][col] = 0
            row+=1
        elif(room[row][col+1]==1): #옆으로
            room[row][col+1] = 0
            col+=1
        else:
            col+=1
    print(i,"번째",room)
print(robot)