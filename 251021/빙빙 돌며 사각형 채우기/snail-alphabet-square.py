n, m = map(int, input().split())

# Please write your code here.

curAlphabet = 'A'

grid = [[0 for _ in range(m)] for _ in range(n)] 

curX = 0
curY = 0

# 동남서북
dx = [0,1,0,-1]
dy = [1,0,-1,0]

dir = 0

grid[curX][curY] = curAlphabet
# curAlphabet = 'B'

def inRange(x,y) :
    if x>=0 and x<n and y>=0 and y < m :
        return True
    return False

for i in range(1, n * m) :
    nx = curX + dx[dir]
    ny = curY + dy[dir]
    curAlphabet = chr(ord(curAlphabet) + 1)
    if curAlphabet > 'Z' :
        curAlphabet = 'A'

    while not inRange(nx,ny) or grid[nx][ny] != 0 :
        dir = (dir + 1) % 4
        nx = curX + dx[dir]
        ny = curY + dy[dir]

    grid[nx][ny] = curAlphabet

    curX = nx
    curY = ny

for i in range(n) :
    for j in range(m) :
        print(grid[i][j],end=" ")
    print()