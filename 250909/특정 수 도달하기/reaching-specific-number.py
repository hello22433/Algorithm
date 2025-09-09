
sum_val = 0
cnt = 0

arr = list(map(int, input().split()))

for num in arr :
    if num >= 250 :
        break;
    cnt += 1
    sum_val += num

print(f"{sum_val} {sum_val/cnt:.1f}")