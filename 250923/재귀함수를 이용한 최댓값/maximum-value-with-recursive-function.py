n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.

def pro(idx) :
    if idx==0:
        return arr[0]

    return max(pro(idx-1), arr[idx])

print(pro(n-1))