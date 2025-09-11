n,m = map(int,input().split())

num = 1
arr = [[0 for _ in range(n)] for _ in range(n)]
for _ in range(m) :
    r,c=map(int,input().split())
    r-=1
    c-=1

    arr[r][c] = num
    num += 1

for i in range(n) :
    for j in range(n) :
        print(arr[i][j] ,end=" ")
    print()
