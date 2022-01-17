def check(room, M, N):
    trash = 1
    i=0
    
    while(i<M or j<N):
        j=0
        col_sum=0
        print("함수내 i:",i, "함수 내 M", M)
        if(i<M and max(room[i])<=0):
            del room[i]
            M-=1
            continue
        
        if(i>=M):
            k=M-1
        else:
            k=i
        
        while(j<N):
            print(k, j)
            if(room[k][j]==1):
                col_sum=1
                break
            col_sum+=room[k][j]
            print("j:",j)
            j+=1
        if(col_sum==0):
            while(j<0):
                del room[k][j]
                j-=1
            N-=1
        i+=1
        j+=1
    print("함수 내 M:::", M, "함수내 room:", room)
    if(len(room)==0):
        trash=0
        
    print("trash:",trash, "M:", M)
    return trash, M, N

M, N = map(int, input().split())

room = [[0 for _ in range(N)] for _ in range(M)]

for i in range(M):
    room[i] = list(map(int, input().split()))
print("room:",room)
robot = 0
trash, M, N = check(room, M, N)
while(trash != 0):
    row = 0
    col = 0
    robot+=1

    while((row != M-1) or (col != N-1)):
        print("row:", row, "col:", col)
        room[0][0] = 0
        room[M-1][N-1] = 0

        if(col==N-1): #맨오른쪽이면
            room[row+1][col] = 0
            row+=1
        elif(row==M-1): #맨밑이면
            room[row][col+1] = 0
            col+=1
        elif(room[row+1][col] == 1): #밑에 있으면 밑으로
            room[row+1][col] = 0
            row+=1
        elif(room[row][col+1]==1): #옆에 있으면 옆으로
            room[row][col+1] = 0
            col+=1
        else:
            tmp_sum = 0
            idx = row
            while(idx<M):
                tmp_sum=room[idx][col]
                idx+=1
            if(tmp_sum < sum(room[row])):
                col+=1 #row+=1 ?
                room[row][col] = 0
            else:
                row+=1
                room[row][col] = 0

    print("과정이 끝나고 row:", row, "col:", col)
    trash, M, N = check(room, M, N)
    print("함수끝나고 M:", M)
    print(robot,"번째",room)
print(robot)