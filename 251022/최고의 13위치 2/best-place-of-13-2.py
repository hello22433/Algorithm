n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.

max_coins = 0

for i in range(n) :
    for j in range(n-2) :


        for a in range(i,n) :
            if a == i :
                for b in range(j+3, n-2) :
                    max_coins = max(max_coins, arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[a][b] + arr[a][b+1] + arr[a][b+2])

            else :
                for b in range(n-2) :
                    max_coins = max(max_coins, arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[a][b] + arr[a][b+1] + arr[a][b+2])

print(max_coins)
