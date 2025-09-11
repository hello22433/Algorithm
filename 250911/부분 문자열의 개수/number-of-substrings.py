a=input()
b=input()
cnt = 0

for i in range(len(a)) :
    
    if i + len(b) > len(a) :
        break

    equal = True
    for j in range(len(b)) :
        if a[i+j] != b[j] :
            equal = False
            break

    if equal :
        cnt += 1

print(cnt)