import sys

# sys.stdin = open("in1.txt", 'rt')

N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
resNum = []
resultString = ""

if (num[0] > num[len(num)-1]):
    resNum.append(num.pop(len(num)-1))
    resultString+="R"
else:
    resNum.append(num.pop(0))
    resultString+="L"

while(True):
    if (num[0] > num[len(num)-1] and resNum[-1] < num[len(num)-1]):
        resNum.append(num.pop(len(num)-1))
        resultString+="R"
    elif (num[0] < num[len(num)-1] and resNum[-1] < num[0]):
        resNum.append(num.pop(0))
        resultString+="L"
    else:
        if(num[0] > resNum[-1]):
            resNum.append(num.pop(0))
            resultString+="L"
            continue
        elif(num[len(num)-1] > resNum[-1]):
            resNum.append(num.pop(len(num)-1))
            resultString+="R"
            continue
        else:
            break

print(len(resultString))
print(resultString)