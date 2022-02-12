M, G = map(int,input().split())

man = list(map(int,input().split()))
girl = list(map(int,input().split()))

INF=3000000
result=0

#무조건 여자가 적게끔
if(G>M):
    man, girl = girl, man
    M, G = G, M

man.sort()
girl.sort()

DP = [[0 for col in range(M+1)] for row in range(G+1)]

#DP 생성

for row in range(G):
    for col in range(M):
        DP[row][col] = abs(man[col]-girl[row])

print(DP)

tmp = [0]*G

#커플 생성
idx=0
while(idx<G):
    s = []
    for g in range(G):
        minimum=DP[g][0]
        min_idx=0
        for m in range(M):
            if(DP[g][m] < minimum and (m not in s)):
                print("?", DP[g][m])
                minimum=DP[g][m]
                min_idx=m

        s.append(min_idx)
        print("min:", minimum)
        tmp[idx]+=minimum
        if(idx!=0 and tmp[idx] > min(tmp)):
            tmp[idx]=INF
            break
    idx+=1
    print(idx,"번째:",tmp[idx-1])
    del s

print(tmp)
print(min(tmp))

################
# INF=3000000

# man.sort()
# girl.sort()

# if(M>G):
#     for g in range(G):
#         minimum = INF
#         for m in range(M):
#             print(man[m],girl[g])
#             if(man[m]!=INF and abs(man[m] - girl[g]) < minimum):
#                 print("조건문걸릴때min:",minimum)
#                 minimum = abs(man[m]-girl[g])
#                 print("연산후:",minimum)
#                 print("조건문속에서 남자:",man[m], "여자:",girl[g])
#                 min_idx = m
#         man[min_idx] = INF
#         dif.append(minimum)
# else:
#     for m in range(M):
#         minimum = INF
#         for g in range(G):
#             if(girl[g]!=INF and abs(man[m] - girl[g]) < minimum):
#                 print("조건문걸릴때min:",minimum)
#                 minimum = abs(man[m]-girl[g])
#                 print("연산후:",minimum)
#                 print("조건문속에서 남자:",man[m], "여자:",girl[g])
#                 min_idx = g
#         girl[min_idx] = INF
#         dif.append(minimum)

# result = 0
# if(M>G):
#     for i in range(G):
#         result+=dif[i]
# else:
#     for i in range(M):
#         result+=dif[i]
# print("dif:",dif)
# print(result)