a = input()
b = input()
cnt= 0

while a != b :
    a = a[-1] + a[:-1]
    cnt += 1

    if cnt == len(a) :
        break

if a==b:
    print(cnt)
else :
    print(-1)