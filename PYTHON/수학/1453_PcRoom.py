num = int(input())
input_seat = input().split()

seat = []
for i in input_seat:
    seat.append(int(i))

reject = 0

for i in range(0, len(input_seat)):
    for j in range(0, i):
        if(input_seat[i]==input_seat[j]):
            reject+=1
            break
print(reject)