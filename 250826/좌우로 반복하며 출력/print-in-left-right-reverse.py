N = int(input())

for i in range(1,N+1) :
    for j in range(1, N+1) :

        if (i % 2 == 1) :
            print(j, end="")
        else :
            print(N-j+1, end="")
            
    print()