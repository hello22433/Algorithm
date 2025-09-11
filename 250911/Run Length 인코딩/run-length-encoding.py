A = input()
B = ''

# Please write your code here.

pre = A[0]
sameCnt = 1
for a in A[1:] :
    if pre == a :
        sameCnt += 1
    else :
        B += pre + str(sameCnt)
        pre = a
        sameCnt = 1

B += pre + str(sameCnt)

print(len(B))
print(B)