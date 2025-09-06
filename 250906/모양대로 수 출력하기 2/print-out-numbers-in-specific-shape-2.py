n = int(input())

cnt = 2
for i in range(1,n+1) :
    for j in range(1, n+1) :
        print(cnt,end=" ")
        cnt += 2
        if cnt == 10 :
            cnt = 2
    print()