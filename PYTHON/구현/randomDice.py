import sys

N, M = map(int, sys.stdin.readline().split())

table = [0]*(N*M+1)

for i in range(1, N+1):
    for j in range(1, M+1):
        table[i+j]+=1


max = 0
idx = 0

for i, value in enumerate(table):
    if (max < value):
        max = value
        idx = i

for l in range(len(table)):
    if (table[idx] == table[l]):
        print(l, end=' ')