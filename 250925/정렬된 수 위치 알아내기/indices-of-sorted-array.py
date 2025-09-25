n = int(input())
sequence = list(map(int, input().split()))

# Please write your code here.
arr = []

class S :
    def __init__(self,num,val) :
        self.num = num
        self.val = val

for i in range(n) :
    arr.append(S(i,sequence[i]))

arr.sort(key=lambda x: x.val)

new_arr = [0] * n

for idx,e in enumerate(arr,start=1) :
    new_arr[e.num] = idx

for e in new_arr :
    print(e,end=" ")
    
# 숫자 순으로 오름차순 정렬해야 함
# 그 전에 몇 번째 숫자였는지 인덱스를 부여한다.
# 밸류 순으로 오름차순 정렬
# 정렬된 리스트에서 맨 처음 수부터, 저장한 위치에 다시 끼워넣는다. 
# 끼워넣을때는 새로운 배열의 인덱스를 값으로 넣는다