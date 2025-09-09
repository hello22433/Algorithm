arr = list(map(int,input().split()))

one = arr[1::2]
two = arr[2::3]

print(f"{sum(one)} {sum(two)/len(two):.1f}")