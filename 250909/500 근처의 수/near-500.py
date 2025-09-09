arr = list(map(int,input().split()))

import sys

max_val = sys.maxsize
min_val = -sys.maxsize
for num in arr :
    if num < 500 :
        if max_val < num :
            max_val = num
        
    if num > 500 :
        if min_val > num :
            min_val = num
        
print(min_val, max_val)
