arr = list(map(int,input().split()))

maxNum = arr[0]
for num in arr[1:] :
    if num > maxNum :
        maxNum = num

print(maxNum)