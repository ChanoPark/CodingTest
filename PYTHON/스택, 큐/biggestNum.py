import sys

num, m = map(int,sys.stdin.readline().split())
num = list(map(int, str(num))) #각 숫자에 접근하기 위해 str(num)
stack = []
cnt = m

for i in num:
    i = int(i)

    while (cnt > 0 and stack and stack[-1] < i):
        stack.pop()
        cnt-=1
    stack.append(i)

if (cnt != 0):
    stack = stack[:-cnt]

print(''.join(map(str,stack)))