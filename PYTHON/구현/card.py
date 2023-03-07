import sys

N, K = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))


### 내가 푼 풀이는 리스트 -> 집합 -> 리스트로 바꿔서 출력하는 방법이라 비효율적임.
# sumList = []
#
# for i in range(0, N):
#     for j in range(i+1, N):
#         for k in range(j+1, N):
#             sumList.append(card[i] + card[j] + card[k])
#
# total = set(sumList)
# print(sorted(total, reverse=True)[K-1])
###

###그래서 아래처럼 아예 집합으로 만들어서 리스트로 바꿔서 출력

sumList = set()

for i in range(0, N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            sumList.add(card[i] + card[j] + card[k])

print(sorted(sumList, reverse=True)[K-1])