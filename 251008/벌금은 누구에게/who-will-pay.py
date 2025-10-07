N, M, K = map(int, input().split())
student = [int(input()) for _ in range(M)]

arr = [0 for _ in range(N+1)]
check = False
for i in range(M) :
    arr[student[i]] += 1
    if arr[student[i]] == K :
        check = True
        print(student[i])
        break

if not check :
    print(-1)