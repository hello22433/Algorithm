n1,n2 = map(int,input().split())

a = list(map(int,input().split()))
b = list(map(int,input().split()))

freq = False
for i in range(len(a)) :
    numA = a[i]

    if numA == b[0] :
        if b == a[i:i+len(b)] :
            freq = True
            break

if freq :
    print("Yes")
else :
    print("No")

# a 수열을 순회하다가 b[0]을 발견하면
# 