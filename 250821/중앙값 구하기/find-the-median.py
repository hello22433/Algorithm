A,B,C = map(int,input().split())

if (A > B) :
    if (B > C) :
        print(B)
    else : 
        print(C)
else :
    if (A > C) :
        print(A)
    else :
        print(C)