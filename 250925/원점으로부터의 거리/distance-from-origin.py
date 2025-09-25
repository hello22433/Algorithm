n = int(input())
points = [(int(i), tuple(map(int, input().split()))) for i in range(1,n+1)]

# Please write your code here.

points.sort(key = lambda x: (abs(x[1][0]) + abs(x[1][1])))

for e in points:
    print(e[0])