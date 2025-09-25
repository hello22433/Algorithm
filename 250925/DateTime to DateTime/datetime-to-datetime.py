a, b, c = map(int, input().split())
a1,b1,c1 = 11,11,11

# Please write your code here.

times = 0

while True :
    if a1 == a and b1 == b and c1 == c :
        break

    times += 1
    c1 += 1

    if c1 == 60 :
        b1 += 1
        c1 = 0

    if b1 == 24 :
        a1 += 1
        b1 = 0

print(times)
    