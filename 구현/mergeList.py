import sys

N = int(sys.stdin.readline())
firstList = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
secondList = list(map(int, sys.stdin.readline().split()))

res = firstList + secondList
res.sort()

for i in res:
    print(i, end=" ")