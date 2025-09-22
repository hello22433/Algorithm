n, m = map(int, input().split())
A = list(map(int, input().split()))

# Please write your code here.
sum_val = 0

def pro() :
    global n,m,A,sum_val

    while m!=0:
        sum_val += A[m-1] 
        if m%2==1:
            m-=1
        else :
            m//=2

    print(sum_val)

pro()