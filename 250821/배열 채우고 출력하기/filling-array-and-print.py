nums = []
inputs = input().split()

for i in range(10):
    nums.append(inputs[i])

nums.reverse()

for i in range(10):
    print(nums[i], end="")