n = int(input())
x1, y1, x2, y2 = [], [], [], []

arr = [["무" for _ in range(201)] for _ in range(201)]
# 1은 빨 , 2는 파

def inpp(n) :
    return int(n) + 100

for i in range(n):
    a, b, c, d = map(inpp, input().split())
    x1.append(a)
    y1.append(b)
    x2.append(c)
    y2.append(d)

    if i % 2 == 0 : # 빨강
        for j in range(x1[i],x2[i]) :
            for k in range(y1[i],y2[i]) :
                arr[j][k] = "빨"
    else : # 파랑
        for j in range(x1[i],x2[i]) :
            for k in range(y1[i],y2[i]) :
                arr[j][k] = "파"

cnt = 0
for i in range(len(arr)) :
    for j in range(len(arr[i])) :
        if arr[i][j] == "파" :
            cnt += 1

print(cnt)

# Please write your code here.

