N, K = map(int, input().split())
weight = [0 for _ in range(N)]
value = [0 for _ in range(N)]
bag = [0 for _ in range(K)]
for i in range(N):
    weight[i], value[i] = map(int, input().split())
for j in range(K):
    bag[j] = int(input())
bag.sort()
result = 0
while(1):
    big_idx = 0
    big_value = 0
    for l in range(N):
        if(big_value == value[l]/weight[l]):
            if(weight[big_idx] > weight[l]):
                continue
            else:
                big_idx = l
                big_value = value[l]
        elif(big_value < value[l]/weight[l]):
            big_idx = l
            big_value = value[l]
    for m in range(K):
        if(weight[big_idx] < bag[m]):
            result += value[big_idx]
            weight.pop(big_idx)
            value.pop(big_idx)
            bag.pop(m)
            N-=1
            K-=1
            break
        elif(m==K):
            weight.pop(big_idx)
            value.pop(big_idx)
            bag.pop(m)
            N-=1
            K-=1
            break
    if(len(bag)==0):
        break
print(result)