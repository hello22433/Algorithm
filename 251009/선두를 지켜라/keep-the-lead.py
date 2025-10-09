n, m = map(int, input().split())

# Process A's movements
v = []
t = []

arr = [[], []]
oneIdx = 0
for _ in range(n):
    vi, ti = map(int, input().split())
    v.append(vi)
    t.append(ti)

    for i in range(ti) :
        oneIdx += vi
        arr[0].append(oneIdx)

# Process B's movements
v2 = []
t2 = []
twoIdx = 0
for _ in range(m):
    vi, ti = map(int, input().split())
    v2.append(vi)
    t2.append(ti)

    for i in range(ti) :
        twoIdx += vi
        arr[1].append(twoIdx)

sunDoo = -1
cnt = 0
firstSundoo = False
for i in range(len(arr[0])) :
    if arr[0][i] > arr[1][i] and sunDoo != 0 :
        if not firstSundoo :
            firstSundoo = True
            sunDoo = 0
            continue
        cnt += 1
        sunDoo = 0
    elif arr[0][i] < arr[1][i] and sunDoo != 1 :
        if not firstSundoo :
            firstSundoo = True
            sunDoo = 1
            continue
        cnt += 1
        sunDoo = 1
    
print(cnt)

# Please write your code here.

# 현재 값을 기록한다.
# 