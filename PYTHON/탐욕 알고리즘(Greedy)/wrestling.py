import sys

result = N = int(sys.stdin.readline())
player = []

for i in range(N):
    player.append(list(map(int,sys.stdin.readline().split())))

player.sort()

for i in range(N):
    for j in range(i, N):
        if (player[i][1] < player[j][1]):
            result-=1
            break

print(result)