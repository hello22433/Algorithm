n = int(input())
nums = list(map(int, input().split()))

# Please write your code here.

def pri() :
    for e in nums :
        print(e,end=" ")
    print()

nums.sort()
pri()
nums.sort(reverse=True)
pri()