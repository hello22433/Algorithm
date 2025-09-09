start, end = map(int, input().split())

# Please write your code here.

cnt = 0

for num in range(start,end+1) :
    
    sum_val = 0
    for i in range(1,num) :
        if num%i == 0 :
            sum_val += i

    if sum_val == num :
        cnt += 1

print(cnt)