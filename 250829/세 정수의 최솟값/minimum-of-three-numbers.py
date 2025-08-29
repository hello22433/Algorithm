a,b,c = map(int,input().split())

if (a<b) :
    if c<a :
        print(c)
    else :
        print(a)
else :
    if c<b :
        print(c)
    else :
        print(b)