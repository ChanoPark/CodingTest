import sys

# sys.stdin = open("in1.txt", "rt")
N = int(sys.stdin.readline())
prob = list(map(int, sys.stdin.readline().split()))


score = 1
totalScore = 0

for i in prob:
    if (i==1):
        totalScore+=score
        score+=1
    else:
        score=1

print(totalScore)
