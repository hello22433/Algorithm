a=input()
b=input()
c=input()

arr = [a,b,c]

max_len = len(a)
min_len = len(a)

for i in range(1,3) :
    if max_len < len(arr[i]) :
        max_len = len(arr[i])
    if min_len > len(arr[i]) :
        min_len = len(arr[i])
    
print(max_len-min_len)


