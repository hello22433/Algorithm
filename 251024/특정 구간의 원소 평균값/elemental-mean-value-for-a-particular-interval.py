n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.

# 평균값 = 그 구간의 원소 중 하나
# 서로 다른 가짓수
resultCnt = 0
for i in range(n) :
    for j in range(i,n):
        
        sum = 0 
        cnt = 0

        for k in range(i,j+1) :
            sum += arr[k] 
            cnt += 1

        for k in range(i, j+1) :
            if arr[k] == sum/cnt :
                resultCnt += 1
                break

print(resultCnt)
        