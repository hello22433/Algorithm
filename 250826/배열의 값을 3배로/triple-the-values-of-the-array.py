arr = [list(map(int, input().split())) for i in range(3)]

for i in range(3) :
    for j in range(3) :
        print(arr[i][j] * 3, end=" ")
    print()