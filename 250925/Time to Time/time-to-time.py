a, b, c, d = map(int, input().split())

# Please write your code here.
times = 0

while True :
    if a == c and b == d :
        break

    b += 1
    times += 1

    if b == 60 :
        b=0
        a+=1
        
print(times)