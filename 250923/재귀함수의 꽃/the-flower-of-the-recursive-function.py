N = int(input())

# Please write your code here.

def pro(N) :
    if N==0:
        return

    print(N,end=" ") 
    pro(N-1)
    print(N,end=" ")

pro(N)