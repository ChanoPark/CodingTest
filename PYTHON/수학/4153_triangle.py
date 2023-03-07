i = list(map(int, input().split()))

while(sum(i)!=0):
    i.sort()
    if(((i[0]**2)+(i[1]**2)) == (i[2]**2)):
        print("right")
    else:
        print("wrong")
    i = list(map(int, input().split()))