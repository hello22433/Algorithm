n = int(input())
name = []
street_address = []
region = []
mans = []

class S :
    def __init__(self,name,address,region) :
        self.name = name
        self.address=address
        self.region=region

for i in range(n):
    n_i, s_i, r_i = input().split()
    name.append(n_i)
    street_address.append(s_i)
    region.append(r_i)

    mans.append(S(n_i,s_i,r_i))

idx = 0
for i,person in enumerate(mans) :
    if person.anme > mans[idx].name :
        idx = i

print(f"name {people[idx].name}")
print(f"name {people[idx].address}")
print(f"name {people[idx].region}")

# Please write your code here.


