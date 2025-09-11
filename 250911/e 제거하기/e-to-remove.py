s=input()

removeIdx = s.find('e')

print(s[:removeIdx] + s[removeIdx+1:])