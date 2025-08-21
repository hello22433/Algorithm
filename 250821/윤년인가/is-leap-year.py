Y = int(input())

if (Y % 4 or not(Y % 100 == 0 and Y % 400 != 0)) :
    print("true")
else :
    print("false")