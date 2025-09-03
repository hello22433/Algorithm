n = int(input())

check = True

for i in range(2,n) :
    if n % 2 == 0 :
        print("C")
        check = False
        break

if check :
    print("N")