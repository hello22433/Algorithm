n=int(input())

classroom = 0
street = 0
toilet = 0

for i in range(1,n+1) :

    if (i%12==0) :
        toilet+=1
    elif i%3==0:
        street+=1
    elif i%2==0:
        classroom+=1

print(classroom,street,toilet)