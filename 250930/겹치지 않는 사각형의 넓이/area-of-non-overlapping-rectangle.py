x1 = [0] * 3
y1 = [0] * 3
x2 = [0] * 3
y2 = [0] * 3

x1[0], y1[0], x2[0], y2[0] = map(int, input().split())
x1[1], y1[1], x2[1], y2[1] = map(int, input().split())
x1[2], y1[2], x2[2], y2[2] = map(int, input().split())

arr = [[0 for _ in range(2001)] for _ in range(2001)]

# Please write your code here.

for i in range(3):
    for j in range(x1[i], x2[i]) :
        for k in range(y1[i], y2[i]):
            if i == 2 :
                arr[j][k] = 0
            else :
                arr[j][k] += 1

cnt = 0
for a in arr :
    for b in a :
        if b >= 1 :
            cnt += 1
print(cnt)
    