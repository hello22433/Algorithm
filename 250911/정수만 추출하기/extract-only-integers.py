a,b=input().split()

aIdx = len(a)
for i in range(0,len(a)) :
    if not a[i].isdigit() :
        aIdx = i
        break

bIdx = len(b)
for i in range(0,len(b)) :
    if not b[i].isdigit() :
        bIdx = i
        break

print(int(a[:aIdx]) + int(b[:bIdx]))