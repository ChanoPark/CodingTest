N=int(input())

tile = [0 for i in range(N+2)]

tile[2] = 3

for i in range(4, N+1):
    if(i%2==0):
        tile[i] = tile[i-2]*3
        for j in range(i-4, -1, -2):
            tile[i] += tile[j]*2
        tile[i] += 2

print(tile[N])