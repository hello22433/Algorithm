n = int(input())

arr = []
cnt = 0

sqt = 1

while cnt!=2 :
    num = n * sqt
    arr.append(num)
    sqt += 1

    if num % 5 == 0 :
        cnt += 1

for num in arr :
    print(num,end=" ")