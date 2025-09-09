import sys

n = int(input())
a = list(map(int, input().split()))

# Please write your code here.

min_val = -sys.maxsize
sec_min_val = -sys.maxsize

idx = -1

for i in range(len(a)) :
    num = a[i]
    if min_val < num :
        idx = i
        min_val = num

for i in range(len(a)) :
    num = a[i]
    if min_val >= num and sec_min_val < num and i != idx :
        sec_min_val = num


print(min_val,sec_min_val)