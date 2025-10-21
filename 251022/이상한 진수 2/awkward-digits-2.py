a = input()

# Please write your code here.

max_val = 0

for i in range(len(a)) :
    listA = list(a)

    if listA[i] == '1' :
        listA[i] = '0'
    else :
        listA[i] = '1'

    num = "".join(listA)

    max_val = max(max_val, int(num, 2))
    

print(max_val)