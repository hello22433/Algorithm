A = input()
B = input()

# Please write your code here.

while B in A :
    removeIdx = A.find(B)
    
    A = A[:removeIdx] + A[removeIdx+len(B):]

print(A)