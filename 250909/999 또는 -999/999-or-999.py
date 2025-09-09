arr = list(map(int,input().split()))

min_val = arr[0]
max_val = arr[0]
for num in arr :
    if num == 999 or num == -999 :
        break

    if min_val > num :
        min_val = num
    
    if max_val < num :
        max_val = num

print(max_val, min_val)
    