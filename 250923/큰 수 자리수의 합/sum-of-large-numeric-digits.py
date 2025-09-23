a, b, c = map(int, input().split())

# Please write your code here.

def pro(n) :
    if n<10:
        return n

    return pro(n//10) + n%10

print(pro(a*b*c))