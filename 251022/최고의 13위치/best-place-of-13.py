n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.

max_sum = 0
for i in range(n) :
    for j in range(n-2) :
        max_sum = max(max_sum, grid[i][j] + grid[i][j+1] + grid[i][j+2])

print(max_sum)