N, M = map(int, input().split())
arr = [input() for _ in range(N)]

# Please write your code here.

# 동 동남 남 남서 서 서북 북 북동
dxs = [0,1,1,1,0,-1,-1,-1]
dys = [1,1,0,-1,-1,-1,0,1]
cnt = 0

def inRange(x,y) :
    if x>=0 and x<N and y>=0 and y<M :
        return True
    return False
    
for i in range(N) :
    for j in range(M) :
        if arr[i][j] != 'L' :
            continue

        for dx,dy in zip(dxs,dys) :
            curx = i
            cury = j
            curt = 0

            while True :
                nx = curx + dx
                ny = cury + dy

                if not inRange(nx,ny) :
                    break
                if arr[nx][ny] != 'E' :
                    break

                curt += 1
                curx = nx
                cury = ny

                if curt == 2:
                    cnt += 1
                    break

print(cnt)
                


