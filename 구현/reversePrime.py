import sys

def reverse(x):
    res = ""

    for i in range(len(x)-1, -1, -1):
        res += x[i]

    return int(res)

### 아래와 같이 형변환 하지 않고, res*10+t 와 같은 식을 활용해 뒤집을 수 있음.
# def reverse(x):
#     res = 0 
#     while (x>0):
#         t=x%10
#         res = res*10 + t
#         x//=10
#     return res
###

def isPrime(x):
    if(x==1):
        return False

    for i in range(2, 2//x+1): #약수는 절반까지만 있을 수 있다. 그래서 x까지 다 돌지 않고 반절만 돌아도됌.
        if (x%i==0):
            return False
    else:
        return True


N = int(sys.stdin.readline())
num = list(map(str, sys.stdin.readline().split()))

for i in num:
    reverseNum = reverse(i)
    if (isPrime(reverseNum)):
        print(reverseNum, end=' ')