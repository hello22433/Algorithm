n, m = map(int, input().split())

arr = [[0 for _ in range(m)] for _ in range(n)]
num = 1

for col in range(m) :
    row = 0

    while col >= 0 and row <= n-1 :
        arr[row][col] = num

        num += 1

        col -= 1
        row += 1

for row in range(1,n) :
    col = m-1

    while col >= 0 and row <= n-1 :
        arr[row][col] = num

        num += 1

        col -= 1
        row += 1

for i in range(n) :
    for j in range(m) :
        print(arr[i][j] ,end=" ")
    print()

# 열이 계속 늘어남, 동시에 열이 줄어들고 행이 늘어난다