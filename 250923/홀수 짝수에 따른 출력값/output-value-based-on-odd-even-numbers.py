N = int(input())

# Please write your code here.
def pro(n) :
    if n == 1 :
        return 1
    if n == 0 :
        return 0

    return pro(n-2) + n

print(pro(N))

