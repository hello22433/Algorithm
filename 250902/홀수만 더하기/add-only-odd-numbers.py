n=int(input())

sum_val=0

for i in range(n) :
    num= int(input())

    if num%3==0 and num%2==0 :
        sum_val += num

print(sum_val)