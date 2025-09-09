n=int(input())

arr = list(map(int,input().split()))

import sys

min_diff = sys.maxsize
for i in range(len(arr)) :
    for j in range(i+1,len(arr)) :
        diff = abs(arr[i] - arr[j])
        if min_diff > diff :
            min_diff = diff

print(min_diff)