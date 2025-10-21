n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
import sys
minDistance = sys.maxsize
for i in range(1,n-1) :
    curX = x[0]
    curY = y[0]

    distance = 0

    for j in range(1,n) :
        if i == j :
            continue

        nx = x[j]
        ny = y[j]

        distance += abs(curX-nx) + abs(curY-ny)

        curX = nx
        curY = ny

    minDistance = min(minDistance, distance)
    
    
print(minDistance)

