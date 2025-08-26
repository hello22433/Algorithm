N = int(input())
arr = [[0] * N for i in range(N)]

for i in range(N) :
    cnt = 1
    for j in range(N) :
        if (i % 2 == 0) :
            arr[j][i] = cnt
        else :
            arr[N-1-j][i] = cnt
        cnt += 1

for i in range(N) :
    for j in range(N) :
        print(arr[i][j], end="")
    print()