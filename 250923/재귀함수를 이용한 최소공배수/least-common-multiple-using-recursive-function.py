import math

n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.

def choi(a,b) :
    return math.lcm(a,b)

def pro(idx) :
    if idx==0:
        return arr[0]

    return choi(pro(idx-1), arr[idx])

print(pro(n-1))