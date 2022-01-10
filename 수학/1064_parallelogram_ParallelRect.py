ax, ay, bx, by, cx, cy = map(int, input().split())

if ((ax-bx)*(ay-cy)==(ay-by)*(ax-cx)):
    print(-1.0)
    exit(0)

ab_length = ((ax-bx)**2 + (ay-by)**2)**0.5
ac_length = ((ax-cx)**2 + (ay-cy)**2)**0.5
bc_length = ((bx-cx)**2 + (by-cy)**2)**0.5

length = [ab_length+ac_length, ab_length+bc_length, ac_length+bc_length]
result = max(length) - min(length)
print(2*result)


# dif_ab = ax-bx
# dif_ac = ax-cx
# dif_bc = bx-cx

# if(dif_ab == 0):
#     dif_ab = 1
# elif(dif_ac == 0):
#     dif_ac = 1
# elif(dif_bc == 0):
#     dif_bc = 1

# ab_rad = (ay-by)/dif_ab #기울기는 양, 음 둘 다 검사?
# ac_rad = (ay-cy)/dif_ac
# bc_rad = (by-cy)/dif_bc

# dx dy

# #점 B 검사 
# y = x + b


# if (ab_length == )
