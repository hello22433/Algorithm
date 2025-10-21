n = int(input())
a = [int(input()) for _ in range(n)]

# Please write your code here.

# 0 i을 고른다
# 1부터 n-1 까지 j탐색한다. (j-i) * a[j] 가 이동거리

# 0~n-1 i를 고른다
# i에 1부터 n-1을 더한다
# % n을 해서 돌아오도록 한다

# j 이동거리 * (i+j)%n 
import sys

min_sum = sys.maxsize
for i in range(n) :
    sum = 0
    for j in range(1,n) :
        
        sum += j * a[(i+j)%n] 

    min_sum = min(min_sum, sum)


print(min_sum)