while True:
    try:
        n, m = map(int, input().split())
    except:
        break
    result=0

    for num in range(n, m+1):
        count=0
        for end in str(num):
            if (str(num).count(end) > 1):
                count+=1
        if(count==0):
            result+=1

    print(result)