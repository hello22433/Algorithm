n=int(input())

arr = [1,n]

while arr[len(arr)-1] <= 100 :
    arr.append(arr[len(arr)-1] + arr[len(arr)-2])

for num in arr :
    print(num,end=" ")