n = int(input())
price = list(map(int, input().split()))

# Please write your code here.

max_val = 0

for i in range(len(price)) :
    for j in range(i+1,len(price)) :
        profit = price[j] - price[i]
        if max_val < profit :
            max_val = profit

print(max_val)
# 시작점을 고르고 ㄱ