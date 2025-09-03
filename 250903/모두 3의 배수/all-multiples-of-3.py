
c = True 

for i in range(5) :
    num = int(input())

    if num%3 == 0 :
        print(0)
        c = False
        break

if c :
    print(1)