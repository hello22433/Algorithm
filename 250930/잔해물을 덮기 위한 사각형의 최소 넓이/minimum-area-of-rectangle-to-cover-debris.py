import sys

def inpp(n) :
    return int(n) + 1000

x1, y1, x2, y2 = [0] * 2, [0] * 2, [0] * 2, [0] * 2
x1[0], y1[0], x2[0], y2[0] = map(inpp, input().split())
x1[1], y1[1], x2[1], y2[1] = map(inpp, input().split())
arr = [[0 for _ in range(2001)] for _ in range(2001)]
# Please write your code here.

check = False

for i in range(2) :
    for j in range(x1[i], x2[i]):
        for k in range(y1[i], y2[i]) :
            if i == 0 :
                arr[j][k] = 1
                check = True
            else :
                arr[j][k] = 0

minRow = sys.maxsize
maxRow = -sys.maxsize
minCol = sys.maxsize
maxCol = -sys.maxsize

for i in range(len(arr)) :
    for j in range(len(arr[i])) :
        if arr[i][j] == 1 :
            minRow = min(minRow, i)
            maxRow = max(maxRow, i)
            minCol = min(minCol, j)
            maxCol = max(maxCol, j)

if check :
    print((maxRow - minRow + 1) * (maxCol - minCol + 1))
else :
    print(0)