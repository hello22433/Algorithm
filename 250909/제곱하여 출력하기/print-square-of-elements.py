n = int(input())

arr = list(map(int,input().split()))

new_arr = [i**2 for i in arr]

for num in new_arr :
    print(num,end=" ")