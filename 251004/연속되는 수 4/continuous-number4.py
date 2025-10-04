n = int(input())
arr = [int(input()) for _ in range(n)]

# Please write your code here.

max_cnt = 0
cnt = 0

for i in range(len(arr)) :
    if i == 0 or arr[i] > arr[i-1] :
        cnt += 1
    else :
        max_cnt = max(max_cnt, cnt)
        cnt = 1

max_cnt = max(max_cnt, cnt)
# 그 전의 수보다 크면, cnt +1 아니면 1
# 
print(max_cnt)