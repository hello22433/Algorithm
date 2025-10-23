N, K = map(int, input().split())
candy = []
pos = []
arr = [0] * 401
for i in range(N):
    c, p = map(int, input().split())
    candy.append(c)
    pos.append(p)

    arr[pos[i]] += candy[i]

# Please write your code here.

max_sum = 0
for i in range(K,len(arr)-K):
    max_sum = max(max_sum, sum(arr[i-K:i+K+1]))
print(max_sum)