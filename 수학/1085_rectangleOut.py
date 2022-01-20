x, y, w, h = map(int, input().split())

if(w-x>x):
    a=x
else:
    a=w-x

if(h-y>y):
    b=y
else:
    b=h-y

if(a<b):
    print(a)
else:
    print(b)