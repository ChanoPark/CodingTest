import sys

N = int(sys.stdin.readline())

for n in range(1, N+1):
    word = sys.stdin.readline().strip() # sys.stdin.readline() 은 개행 문자를 받기 때문에, 문자열 처리할 때 제거해야 한다.

    ### word[::-1] 과 같이 표현하면 뒤집은 문자열을 만들 수 있다!!
    if (word == word[::-1]):
       print("#{} YES".format(n))
    else:
       print("#{} NO".format(n))
    ###

    # for i in range(0, len(word)//2):
    #     if (word[i].upper() == word[len(word)-1-i].upper()):  #len(word)-1-i == word[-i-1]
    #         continue
    #     else:
    #         print("#{} NO".format(n))
    #         break
    # else:
    #     print("#{} YES".format(n))