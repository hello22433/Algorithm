n = int(input())

a = 'A'
for i in range(n) :
    for j in range(i) :
        print(" ",end=" ")
    for j in range(n-i) :
        print(a,end=" ")
        a = chr(ord(a) + 1)
        if 'A' > a or a > 'Z' :
            a = 'A'
    print()