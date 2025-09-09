start, end = map(int, input().split())

# Please write your code here.

cnt = 0

for num in range(start,end+1) :

    vals = 0
    for i in range(1,num+1) :
        if num % i == 0 :
            vals+=1

    if vals == 3 :
        cnt += 1

print(cnt)