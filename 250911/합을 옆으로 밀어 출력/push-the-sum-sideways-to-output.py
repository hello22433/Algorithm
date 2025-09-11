n=int(input())
a=0
for _ in range(n) :
    a += int(input())

print(str(a)[1:] + str(a)[0])