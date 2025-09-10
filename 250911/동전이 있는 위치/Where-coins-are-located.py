n,m = map(int,input().split())

arr = [[0 for _ in range(n)] for _ in range(n)]

for _ in range(m) :
    r,c= map(int,input().split())
    r=r-1
    c=c-1

    arr[r][c] = 1

for i in range(n) :
    for j in range(n) :
        print(arr[i][j],end=" ")
    print()
