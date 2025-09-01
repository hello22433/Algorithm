cnt=0

for _ in range(3):
    n,m = input().split()

    m=int(m)

    if (n=="Y" and m>=37) :
        cnt+=1

if (cnt >= 2) :
    print("E")
else:
    print("N")