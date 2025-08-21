A,B = map(int, input().split())
nums = [A,B]
print(A, end=" ")
print(B, end=" ")

for i in range(2,10) :
    nums.append((nums[i-2] + nums[i-1]) % 10)
    print(nums[i], end=" ")