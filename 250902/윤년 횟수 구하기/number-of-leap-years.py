n=int(input())
a=0
b=0
for i in range(i,n+1) :
    if i%4==0 and not(i%100==0 and i%400!=0):
        a+=1
    else:
        b+=1

print(a)