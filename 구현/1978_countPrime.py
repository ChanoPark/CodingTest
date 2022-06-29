import sys

N = int(sys.stdin.readline())
num = list(map(int,sys.stdin.readline().split()))

res = 0

boundary = max(num)

DP = [0]*(boundary+1)
primeNumbers = [0]*(boundary+1)

#소수 찾기
for i in range(2,boundary+1):
    if (DP[i] == 0):
        primeNumbers[i]=1
        for j in range(i, boundary+1, i):
            DP[j]=1

#검사
for k in num:
    if (primeNumbers[k]==1):
        res+=1
print(res)