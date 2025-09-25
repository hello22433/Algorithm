n = 5
name = []
height = []
weight = []

arr = []

class S:
    def __init__(self,n,h,w):
        self.n=n
        self.h=h
        self.w=w

for _ in range(n):
    n, h, w = input().split()
    name.append(n)
    height.append(int(h))
    weight.append(float(w))

    
    arr.append(S(n,int(h),float(w)))

print("name")
arr.sort(key=lambda x: x.n)
for e in arr :
    print(e.n,e.h,e.w)

print()
print("height")
arr.sort(key=lambda x: -x.h)
for e in arr :
    print(e.n,e.h,e.w)


# Please write your code here.

