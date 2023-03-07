import sys

n = int(sys.stdin.readline())
meet = []
for i in range(n):
    meet.append(list(map(int,sys.stdin.readline().split())))

### O(N**2)
# for i in range(len(meet)):
#     for j in range(i, len(meet)):
#         if(meet[i][1] > meet[j][1]):
#             tmp = meet[i]
#             meet[i] = meet[j]
#             meet[j] = tmp

### O(NlogN)
meet.sort(key=lambda x : (x[1],x[0]))

result = 1
meeting = meet[0]

for k in range(1, len(meet)):
    if (meeting[1] <= meet[k][0]):

        result += 1
        meeting = meet[k]

print(result)