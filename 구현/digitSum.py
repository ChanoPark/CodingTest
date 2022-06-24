import sys

def digit_sum(x):
    result = 0

    for i in x:
        result+=int(i)
    
    return result

### MAIN ###
N = int(sys.stdin.readline())
numList = list(map(str, sys.stdin.readline().split()))

maxValue = 0
idx = 0 

for i in range(len(numList)):
    digit = digit_sum(numList[i])
    if (maxValue < digit):
        maxValue = digit
        idx = i

print(numList[idx])