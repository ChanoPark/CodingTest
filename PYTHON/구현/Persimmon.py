import sys

# sys.stdin = open("in3.txt", "rt")

N = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
M = int(sys.stdin.readline())

for m in range(M):
    r, d, cnt = map(int, sys.stdin.readline().split())
    if (cnt > N):
        cnt %= N
    elif (cnt ==N):
        continue

    tmp = []

    # 새로운 리스트에 순서를 맞춰서 끼워 넣기->O(N)
    # if (d == 0): #왼쪽
    #     for i in range(cnt, len(board[r-1])):
    #         tmp.append(board[r-1][i])
    #     for j in range(0, cnt):
    #         tmp.append(board[r-1][j])
    #     board[r-1] = tmp
    # else: #오른쪽
    #     for i in range(len(board[r-1])-cnt, len(board[r-1])):
    #         tmp.append(board[r-1][i])
    #     for j in range(0, len(board[r-1])-cnt):
    #         tmp.append(board[r-1][j])
    #     board[r-1] = tmp

    #pop, insert를 활용하기 -> cnt만큼만!
    if (d == 0):
        for _ in range(cnt):
            board[r-1].append(board[r-1].pop(0))
    else:
        for _ in range(cnt):
            board[r-1].insert(0, board[r-1].pop())


res = 0
center = N//2
i = 0
lt = 0 
rt = N-1
while(i<N):
    if (i<center):
        res += sum(board[i][lt:rt+1])
        lt+=1
        rt-=1
    else:
        res += sum(board[i][lt:rt+1])
        lt-=1
        rt+=1
    i+=1

print(res)
