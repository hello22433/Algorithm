m1, d1, m2, d2 = map(int, input().split())
A = input()

# Please write your code here.

daysOfMonths = [0,31,29,31,30,31,30,31,31,30,31,30,31]
weeks = ["Mon","Tue","Wed","Thu","Fri","Sat","Sun"]
weeksIdx = 0
cnt = 0

while True :

    if weeks[weeksIdx%7] == A :
        cnt += 1

    if m1==m2 and d1==d2 :
        break

    d1 += 1
    weeksIdx += 1

    if d1 > daysOfMonths[m1] :
        m1 +=1
        d1 = 1

print(cnt)
