s,q=input().split()

q= int(q)

for _ in range(q) :
    arr = input().split()

    if int(arr[0]) == 1 :
        a,b=int(arr[1])-1,int(arr[2])-1
        sArr = list(s)

        tmp = sArr[a]
        sArr[a] = sArr[b]
        sArr[b] = tmp

        s = "".join(sArr)

        print(s)

    
    else :
        x,y = arr[1],arr[2]

        s = s.replace(x,y)
        print(s)
