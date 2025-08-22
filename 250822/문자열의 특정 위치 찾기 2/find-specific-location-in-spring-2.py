strs = ["apple","banana","grape","blueberry","orange"]
inputS = input()
answer = 0

for s in strs :
    if (s[2] == inputS or s[3] == inputS) :
        print(s)
        answer += 1

print(answer)