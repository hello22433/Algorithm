N, S = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.

min_diff = S

for i in range(N) :
    for j in range(i+1,N) :

        sum = 0
        for k in range(N) :
            if k == i or k == j :
                continue

            sum += arr[k]

        min_diff = min(min_diff, abs(S-sum))

print(min_diff)