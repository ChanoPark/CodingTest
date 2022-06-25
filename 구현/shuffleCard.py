import sys

# card = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
card = list(range(1,21))

for i in range(10):
    s, e = map(int, sys.stdin.readline().split())

    sorted = card[s-1:e][::-1] #부분 슬라이싱 후 뒤집기.

    for j in range(len(sorted)):
        card[s-1+j] = sorted[j]

for k in card:
    print(k, end=" ")