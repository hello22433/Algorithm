arr = list(map(int,input().split()))

one = arr[0::2]
two = arr[1::2]

print(abs(sum(one)-sum(two)))