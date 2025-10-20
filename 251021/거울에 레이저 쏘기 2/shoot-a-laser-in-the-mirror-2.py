n = int(input())
grid = [list(input()) for _ in range(n)]
k = int(input())

# 동남서북 0 1 2 3
dx = [0,1,0,-1]
dy = [1,0,-1,0]

# (K-1)을 N으로 나눈다. -> 몫이 0이면 북에서, 1:동, 2:남, 3:서
# 1 2 3 0

# remain = (K-1)을 N으로 나눈 나머지

# 몫이
# 0이면 x = -1 : y = remain
# 2이면 x = n : y = n-1 - remain
# 1이면 y = n : x = remain
# 3이면 y = -1 : x = n-1 - remain

# \을 만나면, 남->동 / 서->북 / 동->남 / 북->서
# /을 만나면, 남->서 / 동->북 / 북->동 / 서->남

quot = ((k-1) // n)
remain = ((k-1) % n)
dir = (quot + 1) % 4

curX = 0
curY = 0
if quot==0 :
    curX, curY = -1, remain
elif quot== 2:
    curX, curY = n, n-1 - remain
elif quot== 1: 
    curX, curY = remain, n
else :
    curX, curY = n-1 - remain, -1

def inRange(x,y) :
    if x>=0 and x<n and y>=0 and y<n :
        return True
    return False

def move(x,y) :
    global curX, curY

    curX += dx[dir]
    curY += dy[dir]

def pingPong(x,y) :
    global dir

    if grid[x][y] == "\\":
        if dir==1 :
            dir = 0
        elif dir==0 :
            dir = 1
        elif dir == 2:
            dir = 3
        else :
            dir = 2
    else :
        if dir==1 :
            dir = 2
        elif dir==2 :
            dir = 1
        elif dir == 0:
            dir = 3
        else :
            dir = 0

cnt = 0
while True :

    
    move(curX, curY)

    if not inRange(curX, curY) :
        break

    pingPong(curX,curY)

print(cnt)
