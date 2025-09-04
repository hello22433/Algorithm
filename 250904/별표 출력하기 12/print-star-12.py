n=int(input())

for i in range(1,n+1) :
    
    for j in range(1,n+1) :

        if j >= i and (i==1 or j % 2 == 0):
            print("*",end=" ")
        else :
            print(" ",end=" ")

    print()