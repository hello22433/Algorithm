aage, asex = input().split()
bage, bsex = input().split()

aage = int(aage)
bage = int(bage)

if (aage>=19 and asex=='M') or (bage>=19 and bsex=='M') :
    print(1)
else :
    print(0)