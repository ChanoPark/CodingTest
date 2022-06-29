import sys

##무조건 답을 기준으로 이진탐색을 고려!!
# sys.stdin = open("in1.txt", "rt")

N, M = map(int, sys.stdin.readline().split())
dvd = list(map(int, sys.stdin.readline().split()))

lt = 1
rt = sum(dvd)
maximum = max(dvd)

#일단 M개로 될떄까지 반복
res = 0
while(lt<=rt):
    cnt = 1
    tmp = 0
    center = (lt+rt)//2

    for i in dvd:
        if (tmp + i > center):
            cnt+=1
            tmp =i
        else:
            tmp+=i
    
    if (center>=maximum and cnt <= M):
        res = center
        rt = center-1
    else:
        lt = center+1
        
    # print(res, center, cnt, rt, lt)

print(res)