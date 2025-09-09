n = int(input())

num = 1

arr = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n) :
    for j in range(n) :
        arr[j][i] = num
        num+=1

for i in range(n) :
    for j in range(n) :
        print(arr[i][j],end=" ")
    print()