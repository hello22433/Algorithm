n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.


arr = [0] * 101
maxUpon = 0

for s in segments :
    for i in range(s[0], s[1] + 1) :
        arr[i] += 1
        maxUpon = max(maxUpon, arr[i])

print(maxUpon)