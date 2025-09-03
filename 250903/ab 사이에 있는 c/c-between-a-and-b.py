a,b,c= map(int,input().split())

check = False
for i in range(a,b+1) :
    if i % c == 0:
        print("YES")
        check = True
        break

if not check :
    print("NO")