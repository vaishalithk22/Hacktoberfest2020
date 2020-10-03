# Draw rectangle
import math

def rectangle(width, height, character):
    line = character * width           

    for i in range(height):
        print(line)

w = int(input("Input width: "))
h = int(input("Input height: "))
c = input("Input character: ")
rectangle(w, h, c)
