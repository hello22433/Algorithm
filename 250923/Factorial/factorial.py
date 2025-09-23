N = int(input())

# Please write your code here.

def pro(n) :
    if n == 1 :
        return 1

    return pro(n-1) * n

print(pro(N))