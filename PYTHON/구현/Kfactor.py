import sys

N, K = map(int, sys.stdin.readline().split())

cnt=0

for i in range(1, N+1):
    if (N%i==0):
        cnt+=1
    if (cnt==K):
        print(i)
        break
else:
    print(-1)

""" while문을 활용한 풀이
cnt=0
num=1

while(cnt!=K):
    if (N%num==0):
        cnt+=1
    if (num>N):
        break
    num+=1

if (cnt<K):
    print(-1)
else:
    print(num-1)
"""