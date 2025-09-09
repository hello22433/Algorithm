arr = list(map(int,input().split()))

zeroIdx = len(arr)
for i in range(len(arr)) :
    if arr[i] == 0 :
        zeroIdx = i
        break

for i in range(zeroIdx-1,-1,-1) :
    print(arr[i],end=" ")