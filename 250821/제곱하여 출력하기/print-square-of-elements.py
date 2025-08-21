N = int(input())
inputs = input().split()

for i in range(N) :
    inputs[i] = inputs[i] ** 2
    print(inputs[i], end=" ")
