n=int(input())

for i in range(1,n+1) :
    if i%3==0 :
        print(0,end=" ")
    else :
        num = i
        
        remain = num%10
        num //= 10
        check = False
        while remain != 0 :
            if remain==3 or remain==6 or remain==9 :
                print(0,end=" ")
                check = True
                break;
            remain = num%10
            num //= 10
        
        if not check :
            print(i,end=" ")
