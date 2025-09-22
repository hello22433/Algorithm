n = int(input())

# Please write your code here.

def p1(n) :
    if n == 0 :
        return
    
    p1(n-1)
    print(n,end=" ")

def p2(n) :
    if n == 0 :
        return

    print(n,end=" ")
    p2(n-1)

p1(n)
print()
p2(n)