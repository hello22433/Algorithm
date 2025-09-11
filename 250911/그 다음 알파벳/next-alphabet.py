a=input()

num = ord(a) + 1

if chr(num) > 'z' :
    a='a'
else :
    a = chr(num)

print(a)