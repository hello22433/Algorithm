n, m = map(int, input().split())

# Process robot A's movements
t = []
d = []

arr = [[], []]

arr[0].append(0)
arr[1].append(0)

oneIdx = 0
for _ in range(n):
    time, direction = input().split()
    t.append(int(time))
    d.append(direction)

    dir = 0;
    if direction == 'L' :
        dir = -1
    else :
        dir = 1

    for i in range(int(time)) :
        oneIdx += dir
        arr[0].append(oneIdx)

# Process robot B's movements
t_b = []
d_b = []

twoIdx = 0
for _ in range(m):
    time, direction = input().split()
    t_b.append(int(time))
    d_b.append(direction)

    dir = 0;
    if direction == 'L' :
        dir = -1
    else :
        dir = 1

    for i in range(int(time)) :
        twoIdx += dir
        arr[1].append(twoIdx)

# print(arr)
# Please write your code here.
cnt = 0
  
for i in range(1, max(len(arr[0]),len(arr[1]))) :

    if len(arr[0]) > len(arr[1]) and i >= len(arr[1]) :
        if i == len(arr[1]) :
            if arr[0][i] == twoIdx and arr[0][i-1] != arr[1][i-1] :
                cnt += 1
        else :
            if arr[0][i] == twoIdx and arr[0][i-1] != twoIdx :
                cnt += 1
        
    elif len(arr[0]) < len(arr[1]) and i >= len(arr[0]) :
        if i == len(arr[0]) :
            if arr[1][i] == oneIdx and arr[1][i-1] != arr[0][i-1] :
                cnt += 1
        else :
            if arr[1][i] == oneIdx and arr[1][i-1] != oneIdx :
                cnt += 1
    else :
        if arr[0][i] == arr[1][i] and arr[0][i-1] != arr[1][i-1] :
            cnt += 1

print(cnt)