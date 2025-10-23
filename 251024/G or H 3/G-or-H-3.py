n, k = map(int, input().split())
x = []
c = []
arr = [0] * 10001
for i in range(n):
    pos, char = input().split()
    x.append(int(pos))
    c.append(char)
    if c[i] == 'G':
        arr[x[i]] = 1
    elif c[i] == 'H' :
        arr[x[i]] = 2


max_sum = 0 
for i in range(1,len(arr)-k) :
    sum = 0
    for j in range(i,i+k+1) :
        sum += arr[j]

    max_sum = max(max_sum,sum)

print(max_sum)


# Please write your code here.

