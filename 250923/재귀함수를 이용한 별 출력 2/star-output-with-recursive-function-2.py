n = int(input())

# Please write your code here.

def pro(n) :
    if n == 0 :
        return

    print("* "*n)
    pro(n-1)
    print("* "*n)

pro(n)