n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []

startIdx = 100000
arr = [""] * 200001


for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

    if direction=='L' :
        arr[startIdx] = 'h'
        for _ in range(int(num)-1) :
            startIdx -= 1
            arr[startIdx] = 'h'
    else :
        arr[startIdx] = 'b'
        for _ in range(int(num)-1) :
            startIdx += 1
            arr[startIdx] = 'b'

hen = 0
gum = 0

for e in arr :
    if e == 'b' :
        gum += 1
    elif e == 'h' :
        hen += 1

print(hen,gum)
