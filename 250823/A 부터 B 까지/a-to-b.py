A,B = map(int, input().split())

i = A

while (i <= B) :
    print(i, end=" ")
    if (i % 2 == 1) :
        i *= 2
    else :
        i += 3