product_name, product_code = input().split()
product_code = int(product_code)

# Please write your code here.

class S:
    def __init__(self,product_name,product_code) :
        self.product_name = product_name
        self.product_code = product_code

s1 = S("codetree",50)
s2=S(product_name,product_code)

print(f"product {s1.product_name} is {s1.product_code}")
print(f"product {s2.product_name} is {s2.product_code}")