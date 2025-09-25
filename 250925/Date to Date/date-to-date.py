m1, d1, m2, d2 = map(int, input().split())

# Please write your code here.

daysOfMonth = [0,31,28,31,30,31,30,31,31,30,31,30,31]

times = 0

while True :
    if m1 == m2 and d1 == d2 :
        break

    d1 += 1
    times += 1

    if d1 > daysOfMonth[m1] :
        m1 += 1
        d1 = 1

print(times)