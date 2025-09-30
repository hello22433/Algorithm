n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x, y = zip(*points)
x, y = list(x), list(y)

# Please write your code here.

arr = [[0 for _ in range(201)] for _ in range(201)]

for i in range(len(x)) :

    for j in range(x[i], x[i]+8) :
        for k in range(y[i], y[i]+8) :
            arr[j][k] += 1

cnt = 0
for a in arr :
    for b in a :
        if b >= 1 :
            cnt += 1

print(cnt)