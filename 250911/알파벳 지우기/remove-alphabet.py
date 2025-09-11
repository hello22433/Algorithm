a=input()
b=input()

anum = ''
bnum = ''

for k in a :
    if k.isdigit() :
        anum += k

for k in b :
    if k.isdigit() :
        bnum += k

print(int(anum) + int(bnum))