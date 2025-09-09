n,q=map(int,input().split())

arr = list(map(int,input().split()))

for _ in range(q) :
    arr2 = list(map(int,input().split()))

    if arr2[0] == 1 :
        a = arr2[1]-1
        print(arr[a])
    elif arr2[0] == 2 :
        b = arr2[1]

        if b in arr :
            print(arr.index(b)+1)
        else :
            print(0)
    else :
        s = arr2[1]-1
        e = arr2[2]-1

        for num in arr[s:e+1] :
            print(num,end=" ")
        print()