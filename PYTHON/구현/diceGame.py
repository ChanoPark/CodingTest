import sys

N = int(sys.stdin.readline())

price = []

for n in range(N):
    dice = list(map(int, sys.stdin.readline().split()))

    # 3개가 같은 경우
    # 1 1 1 

    # 2개가 같은 경우 
    # 1 1 0 
    # 1 0 1
    # 0 1 1

    if (dice[0] == dice[1]):
        if (dice[0]==dice[2]): #3개 같은 경우
            price.append(10000+dice[0]*1000)
        else: #1 1 0 인 경우
            price.append(1000+dice[0]*100)
    elif (dice[0] == dice[2] or dice[1] == dice[2]): #2개 같은 경우
        price.append(1000+dice[2]*100)
    else: #안 겹치는 경우
        price.append(max(dice)*100)

print(max(price))