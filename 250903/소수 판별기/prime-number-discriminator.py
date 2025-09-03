n = int(input())

for i in range (2,n) :
    if n % 2 == 0 :
        print("C")
        break
    
    if i == n-1 :
        print("P")