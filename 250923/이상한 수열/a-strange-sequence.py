N = int(input())

# Please write your code here.

def pro(n) :
    if n==0:
        return 0
    if n==1:
        return 1
    if n==2:
        return 2

    return pro(n-1) + pro(n//3)

print(pro(N))