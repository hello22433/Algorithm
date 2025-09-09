n = int(input())
nums = list(map(int, input().split()))

# Please write your code here.
max_val = -1
for num in nums :
    if (nums.count(num) == 1 and max_val < num) :
        max_val = num
    
print(max_val)