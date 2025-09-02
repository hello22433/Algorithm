a,b=map(int,input().split())
if a%2==1:
    a+=1

sum_val=0
for i in range(a,b+1,2) :
    sum_val+=i

print(sum_val)