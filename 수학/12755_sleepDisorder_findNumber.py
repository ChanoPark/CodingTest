N = int(input())

digit = 1
i = 2
j = 1
prev = 9
maximum = 9

if(N<10): # 한 자릿수 숫자는 N과 같다.
    print(N)
    exit(0)

#N은 몇번째 자릿수인지? , 각 자릿수별 최소 범위를 찾아서 찾음, 자릿수별 범위는 이전 최대값~현재 최대값
while(1):
    maximum += 9*(10**j)*i
    if(prev < N and maximum >= N):
        print(i)
        break
    i+=1
    j+=1
    prev=maximum
# i=자릿수 / j=0붙여주기

cnt = (N-(prev+1))//i  # 각 자릿수별 최소숫자(1,10,100)으로부터 몇 번째 숫자인지?
num = (10**(i-1)) + cnt # 그럼 N이 가리키고 있는 숫자는 무엇인지?
num = str(num) # 숫자를 인덱스로 접근하기 위한 캐스팅
d = (N-(prev+1))%i # N은 숫자의 몇 번째인지? -> num=123 이면, 123의 몇번째 숫자인지?
print(num[d]) # 답