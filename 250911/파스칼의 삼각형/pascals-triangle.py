n = int(input())

arr = [[0 for _ in range(n)] for _ in range(n)]

for i in range(0,n) :
    for j in range(0,i+1) :
        if i==0 or j==0 or i==j :
            arr[i][j] = 1
        else :
            arr[i][j] = arr[i-1][j-1] + arr[i-1][j]

for i in range(n) :
    for j in range(i+1) :
        print(arr[i][j],end=" ")
    print()