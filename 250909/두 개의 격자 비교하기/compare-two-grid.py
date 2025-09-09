n,m=map(int,input().split())

arr1 = [list(map(int,input().split())) for _ in range(n)]
arr2 = [list(map(int,input().split())) for _ in range(n)]

new_arr = [[0 for _ in range(m)] for _ in range(n)]

for i in range(n) :
    for j in range(m) :
        if arr1[i] == arr2[j] :
            new_arr[i][j] = 1
        else :
            new_arr[i][j] = 0
        print(new_arr[i][j],end=" ")
        
    print()