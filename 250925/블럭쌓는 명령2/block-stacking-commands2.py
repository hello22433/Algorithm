n, k = map(int, input().split())
commands = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.

arr = [0] * (n+1)
num = 0

for com in commands :
    ai = com[0]
    bi = com[1]

    for i in range(ai,bi+1) :
        arr[i] += 1
        num = max(num, arr[i])

print(num)