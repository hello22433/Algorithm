n = int(input())

for i in range(n) :
    a,b= map(int,input().split())

    num = 1
    for j in range(a,b+1) :
        num *= j
        
    print(num)