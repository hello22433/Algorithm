N = int(input())

# Please write your code here.

def pro(n) :
    if n== 1:
        return 2
    if n==2:
        return 4

    return pro(n-1) * pro(n-2) % 100

print(pro(N))