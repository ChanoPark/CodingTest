TC = int(input())

for _ in range(TC):
    func = input()
    N = int(input())
    
    lock=0
    cnt=0

    num = input().split(",")
    num[0]=num[0].strip("[")
    num[len(num)-1] = num[len(num)-1].strip("]")
    
    if(N==0):
        for m in func:
            if(m=='D' and len(num[0])==0):
                print("error")
                lock=1
                break
    else:
        num = list(map(int, num))
    
    if (lock==0):
        for i in func:
            if(i=='R'):
                cnt+=1
            elif(i=='D'):
                if(len(num)==0):
                    lock=1
                    print("error")
                    break
                elif(cnt%2==1):
                    num.pop()
                else:
                    num.pop(0)
            else:
                lock=1
                print("error")
                break
        
    if(lock==0):
        if(cnt%2==1):
            num.reverse()
        print("[",end="")
        
        idx=0
        while(idx<len(num)):
            print(num[idx],end="")
            if(idx==len(num)-1):
                break
            print(",",end="")
            idx+=1
        print("]")
    else:
        continue