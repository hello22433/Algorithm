n = int(input())
a = list(map(int, input().split()))

# Please write your code here.

min_val = a[0]
sec_min_val = a[0]

for num in a :
    if min_val < num :
        min_val = num
    elif min_val >= num and sec_min_val < num:
        sec_min_val = num

print(min_val,sec_min_val)