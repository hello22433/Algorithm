n = int(input())
name = []
height = []
weight = []

arr = []

class S :
    def __init__(self,n,h,w) :
        self.n = n
        self.h = h
        self.w = w
        
for _ in range(n):
    n_i, h_i, w_i = input().split()
    name.append(n_i)
    height.append(int(h_i))
    weight.append(int(w_i))
    arr.append(S(n_i,int(h_i),int(w_i)))

arr.sort(key=lambda x: (x.h,-x.w))

for e in arr:
    print(e.n,e.h,e.w)