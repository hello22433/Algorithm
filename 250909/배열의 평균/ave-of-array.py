

row_aver = 0
colum_aver = 0
total_aver = 0

arr_2d = [list(map(int,input().split())) for i in range(2)]

for i in range(2) :
    print(f"{sum(arr_2d[i])/4:.1f}",end=" ")
print()

for i in range(4) :
    sum_val = 0
    for j in range(2) :
        sum_val += arr_2d[j][i]
        
    print(f"{sum_val/2:.1f}",end=" ")
print()

sum_val = 0 
for i in range(2) :
    sum_val += sum(arr_2d[i])
print(f"{sum_val/8:.1f}")