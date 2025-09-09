a,b=map(int,input().split())

arr = [0,a,b]
print(arr[1],arr[2],end=" ")

for i in range(3,11) :
    arr.append((arr[i-1] + arr[i-2]) % 10)
    print(arr[i],end=" ")