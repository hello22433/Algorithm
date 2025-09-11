a=input()

for k in a:
    if k.isalpha() :
        print(k.lower(),end="")
    elif k.isdigit() :
        print(k,end="")