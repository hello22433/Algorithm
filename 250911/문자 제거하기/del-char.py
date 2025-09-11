s=input()

while len(s) > 1 :
    
    removeIdx = int(input())

    if removeIdx <= len(s)-1 :
        s = s[:removeIdx] + s[removeIdx+1:]
    else :
        s = s[:len(s)-1]
        
    print(s)