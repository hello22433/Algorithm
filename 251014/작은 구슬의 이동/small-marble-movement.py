n, t = map(int, input().split())
r, c, d = input().split()
r, c = int(r)-1, int(c)-1

# Please write your code here.

mapping = {'U':0, 'R':1, 'L':2, 'D':3}
# 북 동 서 남

dir = mapping[d]

x = r
y = c

dx = [-1,0,0,1]
dy = [0,1,-1,0]

def inRange(x,y) :
    if x >= 0 and x < n and y >= 0 and y < n :
        return True
    return False

for i in range(t) :
    nx = x + dx[dir]
    ny = y + dy[dir]

    if inRange(nx,ny) :
        x = nx
        y = ny
    else :
        dir = 3 - dir

print(x+1,y+1)
