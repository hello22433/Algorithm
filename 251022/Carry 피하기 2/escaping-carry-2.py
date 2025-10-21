n = int(input())
arr = [int(input()) for _ in range(n)]

# Please write your code here.

max_sum =0

def occur_sum_carry(num1,num2) :
    while num1 != 0 and num2 != 0 :
        if num1%10 + num2%10 >= 10 :
            return True
        num1 //= 10
        num2 //= 10
    return False

for i in range(n) :
    for j in range(i+1,n) :
        for k in range(j+1,n) :
            if not occur_sum_carry(arr[i],arr[j]) and not occur_sum_carry((arr[i]+arr[j]),arr[k]) :
                max_sum = max(max_sum,arr[i]+arr[j]+arr[k])

print(max_sum)