
def to_upper(s) :
    return s.upper()

for _ in range(5):
    arr = list(map(to_upper, input().split()))

    for i in range(len(arr)) :
        print(arr[i],end=" ")
    print()