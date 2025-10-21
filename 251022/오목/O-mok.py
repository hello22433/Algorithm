board = [list(map(int, input().split())) for _ in range(19)]

# Please write your code here.

result = 0
x = 0
y = 0

for i in range(19-5) :
    for j in range(19-5) :
        if (board[i][j]==1 and board[i+1][j]==1 and board[i+2][j]==1 and board[i+3][j]==1 and board[i+4][j]==1) :
            result=1
            x = i+2+1
            y = j+1
        elif (board[i][j]==1 and board[i][j+1]==1 and board[i][j+2]==1 and board[i][j+3]==1 and board[i][j+4]==1) :
            result=1
            x = i+1
            y = j+2+1
        elif (board[i][j]==1 and board[i+1][j+1]==1 and board[i+2][j+2]==1 and board[i+3][j+3]==1 and board[i+4][j+4]==1) :
            result=1
            x = i+2+1
            y = j+2+1
        elif (board[i][j]==2 and board[i+1][j]==2 and board[i+2][j]==2 and board[i+3][j]==2 and board[i+4][j]==2) :
            result=2
            x = i+2+1
            y = j+1
        elif (board[i][j]==2 and board[i][j+1]==2 and board[i][j+2]==2 and board[i][j+3]==2 and board[i][j+4]==2) :
            result=2
            x = i+1
            y = j+2+1
        elif (board[i][j]==2 and board[i+1][j+1]==2 and board[i+2][j+2]==2 and board[i+3][j+3]==2 and board[i+4][j+4]==2) :
            result=2
            x = i+2+1
            y = j+2+1

for i in range(4,19) :
    for j in range(19-5) :
        if (board[i][j]==1 and board[i-1][j+1]==1 and board[i-2][j+2]==1 and board[i-3][j+3]==1 and board[i-4][j+4]==1) :
            result=1
            x = i+2+1
            y = j+2+1
        elif (board[i][j]==1 and board[i-1][j+1]==2 and board[i-2][j+2]==2 and board[i-3][j+3]==2 and board[i-4][j+4]==2) :
            result=2
            x = i+2+1
            y = j+2+1

print(result)

if result != 0 :
    print(x,y)