n = int(input())

for i in range(n) :
    a,b= map(int,input().split())

    sum_val = 0
    for num in range(a,b+1) :
        if num%2==0 :
            sum_val += num

    print(sum_val)