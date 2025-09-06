n = int(input())

for i in range(1,n+1) :

    if i%2==1:
        for j in range(1,n+1) :
            print(j,end="")
    else :
        for j in range(1,n+1) :
            print(n-(j-1),end="")
    print()