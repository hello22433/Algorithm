n, m = map(int, input().split())

aArr = []
bArr = []

d = []
t = []
aLoc = 0
bLoc = 0
aArr.append(aLoc)
aArr.append(bLoc)

for _ in range(n):
    direction, time = input().split()
    d.append(direction)
    t.append(int(time))

    for i in range(int(time)) :
        if direction == 'L' :
            aLoc -= 1
        else :
            aLoc += 1
        aArr.append(aLoc)

d2 = []
t2 = []
for _ in range(m):
    direction, time = input().split()
    d2.append(direction)
    t2.append(int(time))

    for i in range(int(time)) :
        if direction == 'L' :
            bLoc -= 1
        else :
            bLoc += 1
        bArr.append(bLoc)

check = True
for i in range(len(aArr)) :
    if aArr[i] == bArr[i] :
        print(i)
        check = False
        break

if check :
    print(-1)

# Please write your code here.

