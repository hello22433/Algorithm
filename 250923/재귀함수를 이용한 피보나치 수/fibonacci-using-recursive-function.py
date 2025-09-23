N = int(input())

# Please write your code here.

def pibo(n) :
    if n == 1 :
        return 1
    if n == 2 :
        return 1

    return pibo(n-1) + pibo(n-2)

print(pibo(N))