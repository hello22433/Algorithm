R, C = map(int, input().split())
grid = [list(input().split()) for _ in range(R)]

# Please write your code here.

firstCol = grid[0][0]
lastCol = grid[R-1][C-1]

cnt = 0

for i in range(1, R-2) :
    for j in range(1, C-2) :
        for a in range(i+1, R-1) :
            for b in range(j+1, C-1) :
                if firstCol != grid[i][j] and grid[i][j] != grid[a][b] and grid[a][b] != lastCol :
                    cnt += 1

print(cnt)