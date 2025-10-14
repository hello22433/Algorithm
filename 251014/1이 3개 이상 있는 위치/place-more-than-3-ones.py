n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.

def isRange(x,y) :
    if x >= 0 and x < n and y >= 0 and y < n :
        return True
    return False

dx = [0,1,0,-1]
dy = [1,0,-1,0]
cnt = 0

for x in range(n) :
    for y in range(n) :
        
        oneCnt = 0
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if isRange(nx,ny) and grid[nx][ny] == 1 :
                oneCnt += 1

        if oneCnt >= 3 :
            cnt += 1

print(cnt)