import sys

# sys.stdin = open("in1.txt", "rt")

N = int(sys.stdin.readline())
farm = [list(map(int, sys.stdin.readline().split())) for _ in range(N)] 

###
# center = N//2
# #첫 번째 줄 가운데
# apple = farm[0][center]

# #위
# for i in range(1, center):
#     apple += farm[i][center]
#     for j in range(1, i+1):
#         apple += farm[i][center+j] + farm[i][center-j]

# #중간
# apple += sum(farm[center]) #346 -> 716

# #아래
# for k in range(center+1, N-1): #k: 4,5
#     apple += farm[k][center]
#     for l in range(N-1-k, 0, -1):
#         apple += farm[k][center+l] + farm[k][center-l]

# #마지막 줄 가운데
# apple += farm[N-1][center]
# print(apple) 
###

"""Start와 end 둘로 나눠서 탐색하면 훨씬 간단하게 표현할 수 있다."""

center = N//2
apple = 0
s=e=center

for i in range(N):
    for j in range(s, e+1):
        apple += farm[i][j]
    if (i<center):
        s-=1
        e+=1
    else:
        s+=1
        e-=1

print(apple)