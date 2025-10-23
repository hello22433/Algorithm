N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
B.sort()

# Please write your code here.

cnt = 0
if M>N :
    print(0)
else :
    for i in range(N-(M-1)) :
        s = []

        for j in range(i,i+M) :
            s.append(A[j])
        s.sort()
        if s == B :
            cnt += 1
    print(cnt)
    
