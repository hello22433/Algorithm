n, m = map(int, input().split())
board = [[0 for _ in range(m)] for _ in range(n)]

# Please write your code here.

def inRange(x,y) :
    if x>=0 and x<n and y>=0 and y<m :
        return True
    return False

# 동남서북
dx = [0,1,0,-1]
dy = [1,0,-1,0]
dir = 1
curX = 0
curY = 0
board[0][0] = 1

for i in range(2,n*m+1) :

    nx = curX + dx[dir]
    ny = curY + dy[dir]

    while (not inRange(nx, ny) or board[nx][ny] != 0) :
        dir = (dir - 1 + 4) % 4
        nx = curX + dx[dir]
        ny = curY + dy[dir]

    board[nx][ny] = i
    curX = nx
    curY = ny

for i in range(n) :
    for j in range(m) :
        print(board[i][j],end=" ")
    print()