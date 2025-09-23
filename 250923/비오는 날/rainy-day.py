n = int(input())
date = []
day = []
weather = []

ds = []

class D :
    def __init__(self,d,dy,w) :
        self.d = d
        self.dy = dy
        self.w = w

for _ in range(n):
    d, dy, w = input().split()
    date.append(d)
    day.append(dy)
    weather.append(w)

    ds.append(D(d,dy,w))

target_idx = -1

for i,d in enumerate(ds) :
    if d.w == "Rain" :
        if target_idx == -1 :
            target_idx = i
        elif d.d < ds[target_idx].d :
            target_idx = i

print(ds[target_idx].d, ds[target_idx].dy, ds[target_idx].w)



