N = int(input())
inputs = list(map(int,input().split()))
nums = []

for i in range(N) :
    num = inputs[i]
    if (num % 2 == 0) :
        nums.append(num)

for i in range(-1,-1-len(nums),-1) :
    print(nums[i], end=" ")