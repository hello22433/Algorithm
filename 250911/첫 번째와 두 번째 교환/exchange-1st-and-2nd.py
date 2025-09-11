a=input()

f = a[0]
s = a[1]

for b in a :
    if b == f :
        print(s,end="")
    elif b == s :
        print(f,end="")
    else :
        print(b,end="")