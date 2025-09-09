n = int(input())

arr= list(map(int,input().split()))

for num in arr[::-1] :
    if num % 2 == 0 :
        print(num, end=" ")