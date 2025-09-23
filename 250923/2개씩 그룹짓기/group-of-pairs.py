n = int(input())
nums = list(map(int, input().split()))

# Please write your code here.


nums.sort()
num = 0
for i in range(n) :
    num = max(num, nums[i] + nums[2*n-1 - i])

print(num)