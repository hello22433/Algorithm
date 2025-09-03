a,b = map(int,input().split())

for i in range(a,b+1) :
    if i % 1920 == 0 and i % 2880 == 0 :
        print(1)
        break

    if i == b :
        print(0)