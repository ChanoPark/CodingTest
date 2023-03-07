N = int(input())
i = N//5
while(i >= 0):
    j = N//3
    while(j >= 0):
        if(N==5*i+3*j):
            print(i+j)
            exit(0)
        j-=1
    i-=1
print("-1")