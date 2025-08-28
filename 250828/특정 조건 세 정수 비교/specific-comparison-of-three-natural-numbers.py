a,b,c = map(int,input().split())

if a == min(a,b,c) :
    print(1)
else :
    print(0)

if a==b and b==c :
    print(1)
else :
    print(0)