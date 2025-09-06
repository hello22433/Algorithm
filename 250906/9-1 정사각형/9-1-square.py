n = int(input())
num = 9
for i in range(1,n+1) :
    for j in range(1,n+1) :
        print(num,end="")
        num -= 1
        if num == 0 :
            num = 9
    print()