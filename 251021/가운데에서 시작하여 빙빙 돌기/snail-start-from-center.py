n = int(input())
grid = [[0] * n for _ in range(n)]

# Please write your code here.

curX = n - 1
curY = n - 1

# 동남서북
dx = [0,1,0,-1]
dy = [1,0,-1,0]

dir = 2

grid[curX][curY] = n*n

def inRange(x,y) :
    if x>=0 and x<n and y>=0 and y<n :
        return True
    return False

for i in range(n*n-1,0,-1) :
    nx = curX + dx[dir]
    ny = curY + dy[dir]

    if not inRange(nx,ny) or grid[nx][ny] != 0 :
        dir = (dir + 1) % 4
        nx = curX + dx[dir]
        ny = curY + dy[dir]

    grid[nx][ny] = i
    curX = nx
    curY = ny

for i in range(n) :
    for j in range(n) :
        print(grid[i][j],end=" ")
    print()