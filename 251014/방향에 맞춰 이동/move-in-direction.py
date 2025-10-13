n = int(input())
moves = [tuple(input().split()) for _ in range(n)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

# Please write your code here.
x = 0
y = 0

dx = [1,0,-1,0]
dy = [0,-1,0,1]

for i in range(n) :
    if dir[i] == "E" :
        x += dx[0] * dist[i]
        y += dy[0] * dist[i]
    elif dir[i] == 'S' :
        x += dx[1] * dist[i]
        y += dy[1] * dist[i]
    elif dir[i] == 'W' :
        x += dx[2] * dist[i]
        y += dy[2] * dist[i]
    else :
        x += dx[3] * dist[i]
        y += dy[3] * dist[i]
        
print(x,y)