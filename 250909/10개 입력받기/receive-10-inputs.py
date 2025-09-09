arr=list(map(int,input().split()))

idx = len(arr)
for i in range(len(arr)) :
    if arr[i]==0:
        idx = i
        break
        
sum_val = sum(arr[0:idx])
aver = sum_val/len(arr[0:idx])
print(f"{sum_val} {aver:.1f}")