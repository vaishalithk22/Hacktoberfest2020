list = []
n = int(input("Enter size of list:"))
for i in range (1,n+1):
    num = int(input("Enter the number: "))
    list.append(num)
print("Second largest element in list:",sorted(list)[-2])
