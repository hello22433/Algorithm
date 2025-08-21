threeCnt = 0
fiveCnt = 0

for i in range(10) :
    num = int(input())

    if (num % 3 == 0):
        threeCnt += 1
    if (num % 5 == 0) :
        fiveCnt += 1

print(threeCnt, fiveCnt)