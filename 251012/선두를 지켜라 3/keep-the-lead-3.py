N, M = map(int, input().split())

aRecord = [0]
bRecord = [0]

# Process A's movements
v = []
t = []
aCurLoc = aRecord[0]
for _ in range(N):
    vi, ti = map(int, input().split())
    v.append(vi)
    t.append(ti)

    for _ in range(ti) :
        aCurLoc += vi
        aRecord.append(aCurLoc)

# Process B's movements
v2 = []
t2 = []
bCurLoc = bRecord[0]
for _ in range(M):
    vi, ti = map(int, input().split())
    v2.append(vi)
    t2.append(ti)

    for _ in range(ti) :
        bCurLoc += vi
        bRecord.append(bCurLoc)

# -1 : a가 우위
# 0 : 동시
# 1 : b가 우위
curRank = 0
cnt = 0
for i in range(1,len(aRecord)) :
    if aRecord[i] > bRecord[i] :
        nextRank = -1
    elif aRecord[i] < bRecord[i] :
        nextRank = 1
    else :
        nextRank = 0

    if curRank != nextRank :
        curRank = nextRank
        cnt += 1

print(cnt)

# Please write your code here.

