n = int(input())
a = list(map(int, input().split()))

# Please write your code here.

min_num = a[0]

for num in a[1:] :
    if min_num > num :
        min_num = num

print(min_num, a.count(min_num))