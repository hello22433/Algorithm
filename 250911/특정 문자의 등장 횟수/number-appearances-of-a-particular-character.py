s = input()

eeCnt = 0
ebCnt = 0

for i in range(0,len(s)-1) :
    if s[i]=='e' and s[i+1]=='e' :
        eeCnt += 1

    if s[i]=='e' and s[i+1]=='b' :
        ebCnt += 1

print(eeCnt,ebCnt)