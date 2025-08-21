A,B = map(int, input().split())

total = 0

for i intrange(A,B+1):
    if (i%2==0) :
        total += i

print(total)