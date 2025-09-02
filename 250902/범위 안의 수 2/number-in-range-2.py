sum_val = 0
cnt=0

for i in range(10) :
    num = int(input())
    
    if num>=0 and num<=200 :
        sum_val += num
        cnt += 1

print(f"{sum_val} {sum_val/cnt:.1f})