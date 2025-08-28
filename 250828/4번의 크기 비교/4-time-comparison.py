a = int(input())
b,c,d,e = map(int,input().split())

for x in (b,c,d,e) :
    if (a>x) :
        print(1)
    else :
        print(0)