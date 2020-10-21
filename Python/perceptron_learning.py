import numpy as np

#function will be same for both learing just sending different values for NAND and NOR

def get_ycap(x1,x2,t,w0,w1,w2):
    x0 = -1
    wixi = (w0*x0) + (w1*x1) + (w2*x2)
    if wixi > 0:
        return 1
    return 0
    
def change_w0_w1_w2(x1,x2,t,w0,w1,w2,ycap,l):
    x0 = -1 
    w0 = w0 - l*(ycap - t)*x0
    w1 = w1 - l*(ycap - t)*x1
    w2 = w2 - l*(ycap - t)*x2
    return w0,w1,w2


def fun(x1,x2,t,l):
    w0 = np.random.uniform(-1,1)
    w1 = np.random.uniform(-1,1)
    w2 = np.random.uniform(-1,1)
    ycap = [0,0,0,0]
    j = 1
    T = 1
    while(T<=50):
        print("Iteration ",j)
        for i in range(4):
            ycap[i] = get_ycap(x1[i],x2[i],t[i],w0,w1,w2)
            print(w0,"  ",w1,"  ",w2,"  ",t[i],"  ",ycap[i])
            if ycap[i] == t[i]:
                pass
            else:
                w0,w1,w2 = change_w0_w1_w2(x1[i],x2[i],t[i],w0,w1,w2,ycap[i],l)
        j = j + 1
        T = T + 1
        if ycap == t:
            return


x1 = [0,0,1,1]
x2 = [0,1,0,1]
x1_and_x2 = [0,0,0,1]   #and testing set
x1_or_x2 = [0,1,1,1]     #or testing set

print("-----------------------------Perceptron Learning-----------------------------")
l = float(input("Enter Learning Rate :"))  # learning rate

print("-------------------------AND GATE-------------------------")
fun(x1,x2,x1_and_x2,l)
print("-------------------------OR GATE-------------------------")
fun(x1,x2,x1_or_x2,l)
