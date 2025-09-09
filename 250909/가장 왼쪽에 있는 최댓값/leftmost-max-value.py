n = int(input())
a = list(map(int, input().split()))

# Please write your code here.


while True :
    max_val = a[0]
    max_idx = 0

    for idx,num in enumerate(a) :
        if num > max_val :
            max_val = num
            max_idx = idx
    print(max_idx+1,end=" ")
    a = a[:max_idx]
    
    if max_idx == 0 :
        break