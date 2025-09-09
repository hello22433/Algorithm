abcd = [0] * 4

for _ in range(3) :
    man, tem = input().split()
    tem = int(tem)



    if man=='Y' and tem>=37 :
        abcd[0] += 1
    elif man=='N' and tem>=37 :
        abcd[1] += 1
    elif man=='Y' and tem<37 :
        abcd[2] += 1
    else :
        abcd[3] += 1

for i in range(4) :
    print(abcd[i],end=" ") 
    
if abcd[0] >= 2 :
    print('E')