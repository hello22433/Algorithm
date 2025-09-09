arr = list(map(int,input().split()))

cnt_arr = [0] * 11

for i in range(len(arr)) :
    if arr[i] == 0 :
        break
    cnt_arr[arr[i] // 10] += 1

for i in range(10,0,-1) :
    print(f"{i}0 - {cnt_arr[i]}")