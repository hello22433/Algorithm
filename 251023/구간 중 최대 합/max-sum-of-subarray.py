n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.

max_sum = 0
for i in range(n-k+1) :
    sum = 0
    for j in range(i,i+k) :
        sum += arr[j]

    max_sum = max(max_sum,sum)

print(max_sum)