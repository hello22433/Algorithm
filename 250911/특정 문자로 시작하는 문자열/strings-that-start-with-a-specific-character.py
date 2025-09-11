n = int(input())
arr = [input() for _ in range(n)]
c = input()

startCnt = 0
sumLen = 0

for a in arr :
    if a[0] == c :
        startCnt += 1
        sumLen += len(a)


print(f"{startCnt} {sumLen/startCnt:.2f}")