import sys
n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.

minLen = sys.maxsize

for i in range(n) :
    minP = sys.maxsize
    maxP = -sys.maxsize

    for j in range(n) :
        if j == i :
            continue

        if minP > segments[j][0] :
            minP = segments[j][0]
        
        if maxP < segments[j][1] :
            maxP = segments[j][1]
    

    if minLen > maxP - minP :
        minLen = maxP - minP

print(minLen)
# 