tcnt=0
fcnt=0

for i in range(10) :
    num=int(input())

    if num%3==0 :
        tcnt+=1
    if num%5==0:
        fcnt+=1

print(tcnt,fcnt)