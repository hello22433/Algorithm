commands = input()

# Please write your code here.

dir = 3

# 동 남 서 북
dx = [0,1,0,-1]
dy = [1,0,-1,0]

curX = 0
curY = 0 
check = False

cnt = 0

for command in commands :
    if command == 'L' :
        dir = (dir - 1 + 4) % 4 
    elif command == 'R' :
        dir = (dir + 1) % 4
    else :
        curX += dx[dir]
        curY += dy[dir]
    cnt += 1

    if curX == 0 and curY == 0 :
        check = True
        print(cnt)
        break

if not check :
    print(-1)