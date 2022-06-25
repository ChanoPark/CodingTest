import sys

word = sys.stdin.readline()

### 내 풀이: 예외처리를 활용한 것 -> 조금 비효율적임. => isdecimal() 활용
# num = ""
#
# for i in word:
#     try:
#         int(i)
#         num+=i
#     except:
#         continue
#
# num=int(num)

# print(num)

# cnt = 0
# for i in range(1, num+1):
#     if (num % i == 0):
#         cnt+=1

# print(cnt)
###


res = 0
cnt = 0

for i in word:
    if (i.isdecimal()): #isdecimal은 숫자형태를 모두 찾아주는 것, isdigit은 0-9까지만 딱 찾는것
        res = res * 10 + int(i) #마지막 자릿수에 끼워넣기

print(res)

for i in range(1, res+1):
    if (res % i ==0):
        cnt+=1

print(cnt)