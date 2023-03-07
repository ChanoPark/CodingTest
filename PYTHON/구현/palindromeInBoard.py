import sys

# sys.stdin = open("in1.txt", "rt")

board = [list(map(int, sys.stdin.readline().split())) for _ in range(7)]

cnt = 0

for i in range(3):
    for j in range(7):
        tmp = board[j][i:i+5]
        if (tmp == tmp[::-1]):
            cnt+=1
        for k in range(2):
            if (board[i+k][j] != board[i+5-k-1][j]): #열은 [::-1]이 안되니까 직접 양 끝을 비교함
                break
        else:
            cnt+=1

print(cnt)