import sys

N, M = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))

res = 0
tmp = 0

flag = 0
i = 0

while(i < len(num)):
    if (tmp == M):
        res+=1
        tmp-=num[flag]
        flag+=1
    elif (tmp > M):
        tmp-=num[flag]
        flag+=1
    else:
        tmp += num[i]
        i+=1

if (tmp == M):
    res+=1
    
print(res)