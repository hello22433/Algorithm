a,b = map(int,input().split())

cnt_arr = [0] * 11

while a > 1 :
    cnt_arr[a%b] += 1
    a = a//b

sum_val = 0
for num in cnt_arr :
    sum_val += num ** 2

print(sum_val)