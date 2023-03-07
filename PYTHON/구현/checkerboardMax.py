import sys

# sys.stdin = open("in1.txt", "rt")
N = int(sys.stdin.readline())


#두 방법 다 O(N)
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# board = [[]*N]*N
# for i in range(len(board)):
    # board[i] = list(map(int, sys.stdin.readline().split()))


row = col = cross = tmp = 0

#가로 
for i in board:
    row = max(row, sum(i))

#세로
for j in range(N):
    for k in board:
        tmp += k[j]
    
    col = max(col, tmp)
    tmp=0

#대각선(y=-x)
for l in range(N):
    cross += board[l][l]

#대각선(y=x)
for m in range(N-1,-1,-1):
    tmp += board[m][m]

cross = max(cross, tmp)

print(max(row, col, cross))