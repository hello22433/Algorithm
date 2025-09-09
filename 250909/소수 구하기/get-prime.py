n = int(input())

for num in range(2,n+1) :

    isSosoo = True
    for i in range(2,num) :
        if num%i == 0 :
            isSosoo = False
            break;

    if isSosoo :
        print(num,end=" ")