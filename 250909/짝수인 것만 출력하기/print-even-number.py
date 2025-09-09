n=int(input())

arr = list(map(int,input().split()))

new_arr=[i for i in arr if i % 2 == 0]

for i in new_arr :
    print(i,end=" ")