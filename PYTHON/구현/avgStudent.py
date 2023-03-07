import sys

N = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split()))

avg = round(sum(score)/N)

gap = abs(score[0]-avg)
idx = 0

for i in range(1, N):
    if (gap > abs(score[i]-avg)):
        gap = abs(score[i]-avg)
        idx = i
    elif (gap == abs(score[i]-avg) and score[idx] < score[i]):
        gap = abs(score[i]-avg)
        idx = i

print(avg, idx+1)