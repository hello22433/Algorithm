n=int(input())

arr = [input() for _ in range(n)]

sumlen = 0
cntFirstAStr = 0

for a in arr :
    sumlen += len(a)
    if a[0] == 'a' :
        cntFirstAStr += 1

print(sumlen,cntFirstAStr)