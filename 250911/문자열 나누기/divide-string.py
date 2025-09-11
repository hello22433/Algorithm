n = int(input())

arr = input().split()

a = "".join(arr)

for b in range(0,len(a),5) :
    print(a[b:b+5])