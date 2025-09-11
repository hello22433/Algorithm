n,m = map(int,input().split())

arr = [[0 for _ in range(n)] for _ in range(n)]

for _ in range(m) :
    r,c = map(int,input().split())
    num = r*c
    r -= 1
    c -= 1

    arr[r][c] = num

for i in range(n) :
    for j in range(n) :
        print(arr[i][j],end=" ")
    print()