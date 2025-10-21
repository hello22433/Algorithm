n, T = map(int, input().split())
str = input()
board = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.

curX = n//2
curY = n//2
sum = board[curX][curY]

# 동남서북
dx = [0,1,0,-1]
dy = [1,0,-1,0]
dir = 3

def inRange(x,y) :
    if x>=0 and x<n and y>=0 and y<n :
        return True
    return False

for s in str :
    if s == 'L' :
        dir = (dir - 1 + 4) % 4
    elif s == 'R' :
        dir = (dir + 1) % 4 
    else :
        nx = curX + dx[dir]
        ny = curY + dy[dir]

        if not inRange(nx,ny) :
            continue
        
        sum += board[nx][ny]
        curX = nx
        curY = ny

print(sum)