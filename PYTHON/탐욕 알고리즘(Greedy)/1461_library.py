N, M = map(int, input().split())
d = list(map(int,input().split()))

result=0
positive = []
negative = []

for i in d:
    if(i>0):
        positive.append(i)
    else:
        negative.append(i)

positive.sort(reverse=True)
negative.sort()


if(len(negative)==0):
    result+=positive[0]
elif(len(positive)==0):
    result+=abs(negative[0])
elif(abs(negative[0]) < abs(positive[0])):
    result+=positive[0]
    result+=abs(negative[0])*2
else:
    result+=positive[0]*2
    result+=abs(negative[0])


print("처음:", result)
i=1
idx=1
while(len(positive)!=1 and i*M < len(positive)):
    idx=i*M
    print(idx, ":",result)
    if(idx>len(positive)):
        result += positive[-1]*2
    else:
        result += positive[idx]*2
    i+=1
print("po:",result)
i=1
idx=1
while(len(negative)!=1 and i*M < len(negative)):
    idx=i*M
    print(result)
    if(idx>len(negative)):
        result += abs(negative[-1])*2
    else:
        result += abs(negative[idx])*2
    i+=1

print(result)