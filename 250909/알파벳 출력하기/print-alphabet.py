n = int(input())

a = 'A'
for i in range(n) :
    for j in range(i+1) :
        print(a,end="")
        a = chr(ord(a) + 1)
        if ord(a) > 90 :
            a = 'A'
    print()