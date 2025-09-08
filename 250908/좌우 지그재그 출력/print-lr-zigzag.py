n = int(input())


for i in range(1,n+1) :
    for j in range(1,n+1) :
        num = n*(i-1)+j
        num2 = n*i - (j-1)
        if i%2==1 :
            print(num,end=" ")
        else :
            print(num2,end=" ")
    print()