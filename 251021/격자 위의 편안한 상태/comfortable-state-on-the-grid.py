n, m = map(int, input().split())
points = [tuple(map(int, input().split())) for _ in range(m)]

board = [[0 for _ in range(n)] for _ in range(n)]

# 동남서북
dx = [0,1,0,-1]
dy = [1,0,-1,0]

def inRange(x,y) :
    if x>=0 and x<n and y>=0 and y<n :
        return True
    return False

def isPeonAn(x,y) :
    cnt = 0

    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]

        if inRange(nx, ny) and board[nx][ny] == 1 :
            cnt += 1

    if cnt == 3 :
        return True
    return False

for point in points :
    pointX = point[0]-1
    pointY = point[1]-1

    board[pointX][pointY] = 1

    if isPeonAn(pointX, pointY) :
        print(1)
    else :
        print(0)
