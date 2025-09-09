n=int(input())

arr = list(map(int,input().split()))

cnt = 0

for i in range(len(arr)) :
    num = arr[i]
    if num==2 :
        cnt += 1

    if cnt == 3:
        print(i+1)
        break