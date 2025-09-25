N = input()

# Please write your code here.

num = 0
for e in N:
    e = int(e)

    num = num * 2 + e

num *= 17
n=num

digits = []
while True:
    if n < 2 :
        digits.append(n)
        break

    digits.append(n%2)
    n //= 2

for e in digits[::-1]:
    print(e,end="")