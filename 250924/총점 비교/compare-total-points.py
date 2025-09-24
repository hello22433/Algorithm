from functools import cmp_to_key

n = int(input())

name = []
score1 = []
score2 = []
score3 = []

class S :
    def __init__(self,n,s1,s2,s3) :
        self.n=n
        self.s1=s1
        self.s2=s2
        self.s3=s3

arr = []

for i in range(n):
    student_input = input().split()
    name.append(student_input[0])
    score1.append(int(student_input[1]))
    score2.append(int(student_input[2]))
    score3.append(int(student_input[3]))

    arr.append(S(name[i],score1[i],score2[i],score3[i]))

def com(a,b) :
    return (a.s1 + a.s2 + a.s3) - (b.s1 + b.s2 + b.s3)

arr.sort(key=cmp_to_key(com))

for e in arr :
    print(e.n,e.s1,e.s2,e.s3)

# Please write your code here.

