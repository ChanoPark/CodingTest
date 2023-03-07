def compressed_str_len(compressed_str, idx):
    repeat = int(string[idx-2])
    compression_len = 0
    while(compressed_str[idx] != ')'):
        if (compressed_str[idx] == '('):
            len_res, idx = compressed_str_len(compressed_str, idx+1)
            compression_len += len_res
        else:
            compression_len += 1
            idx+=1
    return repeat*compression_len -1, idx+1 #곱하는 숫자가 두 번 계산되기 때문에 1 뺐음

string = input()
length = 0

j = 0
while(j<len(string)):
    if (string[j] == '('):
        len_res, j = compressed_str_len(string, j+1)
        length += len_res
    elif (string[j] == ')'):
        j+=1
        continue
    else:
        length+=1
        j+=1

print(length)