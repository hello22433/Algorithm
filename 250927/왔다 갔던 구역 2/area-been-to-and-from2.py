n = int(input())

arr = [0] * 2001
startIdx = 1000
x = []

dir = []
for _ in range(n):
    xi, di = input().split()
    x.append(int(xi))
    dir.append(di)

# Please write your code here.

for i in range(n) :
    if dir[i] == 'L' :
        for j in range(0, x[i]):
            startIdx -= 1
            arr[startIdx] += 1
    else :
        for j in range(0, x[i]):
            arr[startIdx] += 1
            startIdx += 1

cnt = 0
for e in arr :
    if e >= 2 :
        cnt += 1
print(cnt)
        


# 왼쪽으로 갈때는 도착하는 지점을 기준으로 구간 산정
# 오른쪽으로 갈때는 시작하는 지점
    


