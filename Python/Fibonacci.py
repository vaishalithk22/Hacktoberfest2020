def fibonacci(n):
	n1=0
	n2=1
	for i in range(n):
		print(n1)
		next = n1+n2
		n1=n2
		n2=next
		
n = int(input("Enter no of element in fibonacci series:"))

fibonacci(n)