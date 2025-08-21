A,B,C = map(int,input().split())

if (A > B) :
    if (B > C) :
        print(B)
    else : 
        if (A > C) :
            print(C)
        else :
            print(A)
else :
    if (A > C) :
        print(A)
    else :
        if (B > C) :
            print(C)
        else :
            print(B)