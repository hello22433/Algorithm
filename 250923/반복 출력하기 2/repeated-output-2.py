n = int(input())

# Please write your code here.

def p(n) :
    if n==0 :
        return
    
    p(n-1)
    print("HelloWorld")

p(n)