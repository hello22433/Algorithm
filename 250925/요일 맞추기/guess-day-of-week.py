m1, d1, m2, d2 = map(int, input().split())

# Please write your code here.

daysOfMonths = [0,31,28,31,30,31,30,31,31,30,31,30,31]
weeks = ['Mon','Tue','Wed','Thu','Fri','Sat','Sun']
weeksIdx = 0

def pro(m1,d1,m2,d2) :
    global weeksIdx
    global daysOfMonths

    while True :
        
        if m1 == m2 and d1 == d2 :
            break

        # 만약 m1,d1이 더 나중 날짜라면 거꾸로 가야 할 것이다
        # 

        if m1 >= m2 and d1 > d2 :
            weeksIdx -= 1
            d1 -= 1
        else :
            weeksIdx += 1
            d1 += 1


        if d1 > daysOfMonths[m1] :
            m1 += 1
            d1 = 1
        elif d1 == 1 :
            m1 -= 1
            d1 = daysOfMonths[m1]

pro(m1,d1,m2,d2)

print(weeks[weeksIdx%7])

