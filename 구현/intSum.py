import sys

sys.stdin = open('in1.txt', 'rt')

N, M = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))

res = 0
tmp = 0
flag = 0
i = 0

while(i < len(num)):
    tmp += num[i]
    if (tmp == M):
        res+=1
        tmp=0
        flag=i
    elif (tmp > M):
        i = flag+1
        tmp=0
    else:
        i+=1

print(res)