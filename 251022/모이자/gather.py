n = int(input())
A = list(map(int, input().split()))

import sys

# Please write your code here.

min_total_move = sys.maxsize

for i in range(n) :

    total_move = 0
    for j in range(n) :
        if j == i :
            continue

        total_move += abs(i-j) * A[j]

    min_total_move = min(min_total_move, total_move)

print(min_total_move)