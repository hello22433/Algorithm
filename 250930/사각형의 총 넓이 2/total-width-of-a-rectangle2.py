n = int(input())
x1, y1, x2, y2 = [], [], [], []

arr = [[0 for _ in range(2001)] for _ in range(2001)]
for _ in range(n):
    a, b, c, d = map(int, input().split())
    x1.append(a)
    y1.append(b)
    x2.append(c)
    y2.append(d)

    a += 100
    b += 100
    c += 100
    d += 100

    for i in range(a,c) :
        for j in range(b,d) :
            arr[i][j] += 1

cnt = 0
for i in range(2001) :
    for j in range(2001) :
        if arr[i][j] >= 1 :
            cnt += 1

print(cnt)

# Please write your code here.

