N = int(input())
inputs = list(map(int,input().split()))

for i in range(N) :
    inputs[i] = inputs[i] ** 2
    print(inputs[i], end=" ")
