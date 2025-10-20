N = int(input())
moves = [tuple(input().split()) for _ in range(N)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

# Please write your code here.

cnt = 0
curX = 0
curY = 0

# 동남서북
dx = [0,1,0,-1]
dy = [1,0,-1,0]
check = False

for i in range(N) :
    for j in range(dist[i]):
        if dir[i] == 'E' :
            curX += dx[0]
            curY += dy[0]
        elif dir[i] == 'S' :
            curX += dx[1]
            curY += dy[1]
        elif dir[i] == 'W' :
            curX += dx[2]
            curY += dy[2]
        else :
            curX += dx[3]
            curY += dy[3]

        cnt += 1
        if curX == 0 and curY == 0 :
            print(cnt)
            check = True
            break
    if check :
        break
    

if not check :
    print(-1)
        
