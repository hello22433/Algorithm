n = int(input())

for i in range(11,11+n*2,2) :
    for j in range(0,n*2,2) :
        print(i+j,end=" ")
    print()