import sys

K, N = map(int, sys.stdin.readline().split())

lt=rt=1
line = []

for _ in range(K):
    inputValue = int(sys.stdin.readline())
    line.append(inputValue)

    rt = max(inputValue, rt)

center = (lt+rt)//2

while(lt <= rt):
    cnt = 0
    for l in line:
        cnt += l//center
    
    if (cnt < N):
        rt = center-1
        center = (lt+rt)//2
    else:
        lt = center+1
        center = (lt+rt)//2

print(center)