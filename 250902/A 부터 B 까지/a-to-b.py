a,b=map(int,input().split())

for i in range(a,b+1,1) :
    print(i, end=" ")
    if i%2==1:
        i*=2
    else:
        i+=3
    i-=1