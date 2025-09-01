amat, aeng = map(int,input().split())
bmat, beng = map(int,input().split())

if (amat > bmat) :
    print("A")
elif amat < bmat :
    print("B")
else :
    if aeng >beng :
        print("A")
    elif aeng < beng :
        print("B")