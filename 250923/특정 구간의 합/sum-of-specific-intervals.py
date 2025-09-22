n, m = map(int, input().split())
arr = list(map(int, input().split()))
queries = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.

def pro() :
    for q in queries :
        sum_val = 0
        for i in range(q[0]-1,q[1]+1-1) :
            sum_val += arr[i]
        print(sum_val)

pro()