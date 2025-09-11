arr = [input() for _ in range(10)]
a = input()

existed = False
for i in arr :
    if i[len(i)-1] == a :
        print(i)
        existed = True

if (not existed) :
    print("None")