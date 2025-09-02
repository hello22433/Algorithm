n = int(input())

sum_val = 0
cnt = 0

for i in range(n) :
    num=int(input())

    sum_val += num
    cnt += 1

print(f"{sum_val} {sum_val/cnt:.1f}")