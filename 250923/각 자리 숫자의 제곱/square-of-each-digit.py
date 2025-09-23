N = int(input())

# Please write your code here.

def pro(n) :
    if n<10 :
        return n**2

    return pro(n//10) + (n%10)**2

print(pro(N))