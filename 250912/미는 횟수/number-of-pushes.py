a = input()
b = input()
cnt= 0
while a != b :
    a = a[-1] + a[:-1]

print(cnt)