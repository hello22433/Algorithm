n = int(input())

arr = map(float,input().split())

aver = sum(arr)/n

print(f"{aver:.1f}")

if aver>=4 :
    print("Perfect")
elif aver>=3:
    print("Good")
else :
    print("Poor")