n, m = map(int, input().split())
arr = [[0] * m for _ in range(n)]

# Please write your code here.

dx =[0,1,0,-1]
dy =[1,0,-1,0]

x,y = 0,0
dirnum = 0

arr[x][y] = 1

def inRange(x,y) :
    if x>=0 and x < n and y>=0 and y < m :
        return True
    return False

for i in range(2, n*n+1) :
    
    nx = x + dx[dirnum]
    ny = y + dy[dirnum]

    if inRange(nx,ny) and arr[nx][ny] == 0 :
        arr[nx][ny] = i
        x,y =nx,ny
    else :
        dirnum = (dirnum+1)%4
        nx = x + dx[dirnum]
        ny = y + dy[dirnum]
        arr[nx][ny] = i
        x,y =nx,ny


for i in range(n) :
    for j in range(m) :
        print(arr[i][j], end=" ")
    print()


