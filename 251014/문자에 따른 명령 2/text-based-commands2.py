dirs = input()

# Please write your code here.

dx = [1,0,-1,0]
dy = [0,-1,0,1]

dirnum = 3
x=0
y=0

for s in dirs :
    if s == 'L' :
        dirnum = (dirnum - 1 + 4) % 4
    elif s == 'R' :
        dirnum = (dirnum + 1) % 4
    else :
        x += dx[dirnum]
        y += dy[dirnum]

print(x,y)