n = int(input())
commands = [tuple(input().split()) for _ in range(n)]
x = []
dir = []
startIdx = 100000

class Pan:
    def __init__(self,gum,hen,col) :
        self.gum = gum
        self.hen = hen
        self.col = col

arr = [Pan(0,0,"") for _ in range(200001)]

for num, direction in commands:
    x.append(int(num))
    dir.append(direction)

    if direction == 'L' :
        arr[startIdx].hen += 1
        arr[startIdx].col="hen"
        for _ in range(int(num)-1) :
            startIdx -= 1
            arr[startIdx].hen += 1
            arr[startIdx].col="hen"
    else :
        arr[startIdx].gum += 1
        arr[startIdx].col="gum"
        for _ in range(int(num)-1) :
            startIdx += 1
            arr[startIdx].gum += 1
            arr[startIdx].col="gum"


gum = 0
hen = 0
hwe = 0

for i in arr :
    if i.gum >= 2 and i.hen >= 2 :
        hwe += 1
    elif i.col == 'hen' :
        hen += 1
    elif i.col == 'gum':
        gum += 1

print(hen, gum, hwe)
        

# Please write your code here.




    



# 타일마다 기록되어야 하는 것.
# 검은색으로 칠해진 횟수, 흰색으로 칠해진 횟수, 마지막으로 칠해진 색


# 도착했을때, 2번 2번씩이면 회색으로 바꾼다. 
# 만약 아니면, R일때 검은색, L일 때 흰색