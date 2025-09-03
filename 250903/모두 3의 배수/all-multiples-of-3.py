
c = True 

for i in range(5) :
    num = int(input())

    if num%3 == 1 :
        print(0)
        c = False
        break

if c :
    print(1)