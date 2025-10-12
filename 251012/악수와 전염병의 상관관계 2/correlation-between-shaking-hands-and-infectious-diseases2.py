N, K, P, T = map(int, input().split())
handshakes = [list(map(int, input().split())) for _ in range(T)]

# Please write your code here.

# developers[감염여부 0 1 , 남은 감염 가능 여부]
developers = [[0, K] for _ in range(N+1)]
developers[P][0] = 1

# index(초) , [감염 발생 여부 / 1이 발생, 감염 시키는자, 당하는자]
tArr = [[0, 0, 0] for _ in range(251)]

# * 알고리즘 *
# 악수를 했음. 
# 전염병 횟수 남아있음? -> 하나 깎고 상대를 전염시킴
# 상대가 전염 상태면 그냥 지나감. but 아니라면 전염시키고 K를 채움

for i in range(T) :
    t = handshakes[i][0]
    er = handshakes[i][1]
    ee = handshakes[i][2]

    tArr[t] = [1, er, ee]

for t in tArr :
    occur = t[0]
    er = t[1]
    ee = t[2]

    if occur == 1 :
        eeNew = False

        if developers[er][0] == 1 and developers[er][1] >= 1 :
            developers[er][1] -= 1
            if developers[ee][0] == 0 :
                developers[ee][0] = 1
                eeNew = True

        if not eeNew and developers[ee][0] == 1 and developers[ee][1] >= 1 :
            developers[ee][1] -= 1
            if developers[ee][0] == 0 :
                developers[ee][0] = 1

for i in range(1, len(developers)) :
    if developers[i][0] == 1 :
        print(1,end="")
    else :
        print(0,end="")