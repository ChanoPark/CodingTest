# N = input()
# num = int(input())
# if(num > 0):
#     breakNum = list(map(int,input().split()))
# else: #고장난버튼없으면 걍 이동
#     print(len(N))
#     exit(0)
# INF = 999
# result = 0

# button = []
# for i in range(10):
#     button.append(i)

# j=0
# idx = []
# ##버튼
# while(j<num):
#     for i in breakNum:
#         for k in button:
#             if (i==k):
#                 idx.append(k)
#                 j+=1
# idx.sort(reverse=True)
# for l in idx:
#     button.pop(l)

# #버튼 다 고장남
# if(len(button)==0):
#     print(abs(int(N)-100))
#     exit(0)

# n = ""

# #마지막에 그냥 +,- 버튼 눌러서 가는게 더 작으면 그걸로 하자
# for i in N:
#     tmp = button.copy()
#     for j in range(len(tmp)):
#         tmp[j]=abs(tmp[j]-int(i))
#     n += str(button[tmp.index(min(tmp))])


# if (abs(int(N)-100) > result):
#     print(result)
# else:
#     print(abs(int(N)-100))


N = int(input())
brokenNum = int(input())

if(brokenNum > 0):
    brokenButton = list(map(int,input().split()))
else: #고장난버튼없으면 걍 이동
    print(len(str(N)))
    exit(0)

result = abs(N-100)

for tmp in range(1000001):
    tmp = str(tmp)
    for i in range(len(tmp)):
        if (int(tmp[i]) in brokenButton):
            break
        elif (i==len(tmp)-1): #마지막 자리까지 오면 비교
            result = min(result, abs(int(tmp)-N)+len(tmp))

print(result)