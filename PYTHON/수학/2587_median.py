num = []
avg = 0
for i in range(0,5):
    num.append(int(input()))
    avg+=num[i]

avg = avg//5
num.sort()

print(avg)
print(num[2])