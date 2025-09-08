n = int(input())

alph = 'A'
for i in range(n) :
    for j in range(n) :
        print(alph,end="")
        alph = chr(ord(alph) + 1)

        if j == n-1:
            print()