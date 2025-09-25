a, b = map(int, input().split())
n = input()

# Please write your code here.

# n(a진수) -> 10진수 -> b진수

num = 0
for e in str(n) :
    e = int(e)

    num = num * a + e

digits = []
while True :
    if num < b :
        digits.append(num)
        break

    digits.append(num%b)
    num //= b

for e in digits[::-1] :
    print(e,end="")