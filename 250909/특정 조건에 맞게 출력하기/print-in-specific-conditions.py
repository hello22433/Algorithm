
arr = list(map(int,input().split()))

idx = len(arr)

for i in range(len(arr)) :
    if arr[i] == 0 :
        idx = i
        break

for num in arr[:idx] :
    if num%2==1:
        print(num+3,end=" ")
    else :
        print(num//2,end=" ")