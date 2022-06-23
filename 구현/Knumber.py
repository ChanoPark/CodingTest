import sys

T = int(sys.stdin.readline())

for t in range(1,T+1):
    N, s, e, k = map(int, sys.stdin.readline().split())
    n = list(map(list, sys.stdin.readline().split()))

    #정렬
    for i in range(s-1, e):
        for j in range(i, e):
            if (n[i] > n[j]):
                temp = n[i]
                n[i] = n[j]
                n[j] = temp
    
    print("#{} {}".format(t, n[k+s-2]))