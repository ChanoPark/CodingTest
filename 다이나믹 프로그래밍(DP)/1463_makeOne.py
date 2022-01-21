# INF = 99999999

# def cal(n, cnt):
#     tmp = [INF]*3

#     if(n<=0 or cnt==INF):
#         return INF
#     elif(n==1):
#         return cnt

#     if(n%3==0):
#         if(n%2==0):
#             tmp[0] = cal(n//3, cnt+1)
#             tmp[1] = cal(n//2, cnt+1)
#             tmp[2] = cal(n-1, cnt+1)
#             cnt = min(tmp)
#         else:
#             tmp[0] = cal(n//3, cnt+1)
#             tmp[1] = cal(n-1, cnt+1)
#             cnt = min(tmp)
#     elif(n%2==0):
#         tmp[0] = cal(n//2, cnt+1)
#         tmp[1] = cal(n-1, cnt+1)
#         cnt = min(tmp)
#     else:
#         cnt = cal(n-1, cnt+1)
    
#     return cnt

# N = int(input())

# result = cal(N, 0)

# print(result)

N = int(input())
DP = [0]*(N+1)

for i in range(2,N+1):
    if(i%3==0):
        if(i%2==0): #3, 2 둘 다 나뉘는 경우
            DP[i] = min(DP[i//2], DP[i//3], DP[i-1])+1
        else: # 3으로만 나뉘는 경우
            DP[i] = min(DP[i//3], DP[i-1])+1
    elif(i%2==0): #2로만 나뉘는 경우
        DP[i] = min(DP[i//2],DP[i-1])+1
    else: # 아무것도 나뉘지 않는 경우
        DP[i] =DP[i-1]+1

print(DP[N])