# Rock, Paper, Scissor
import datetime as dt
import random as rd


print("Welcome to the rock paper scissor program! ")
name = input("What is your name? ")
print("Hello, " + str(name) + "!")
dateTime = dt.datetime.now()
print("The date is: " + dateTime.strftime("%d %m %y"))
print("The time is: " + dateTime.strftime("%I %M %S %p"))
result = ""
score = 0
wantsToPlay = True
while (wantsToPlay):
    userChoice = input("Enter your choice: ( Rock | Paper | Scissors | Quit ) ")
    choiceList = ['Rock', 'Paper','Scissors']
    computerChoice = choiceList[rd.randint(0, 2)]

    if (userChoice == 'Rock'):
        if (computerChoice == 'Rock'):
            result = "DRAW"
        elif (computerChoice =='Paper'):
            result = "LOSE"
            score-=1
        elif (computerChoice == 'Scissors'):
            result = "WIN"
            score+=1
    
        print("You chose " + userChoice)
        print("Computer chose " + computerChoice)
        print ("YOU "+ result)
    
    elif (userChoice == 'Paper'):
        if (computerChoice == 'Rock'):
            result = "WIN"
            score+=1
        elif (computerChoice =='Paper'):
            result = "DRAW"
        elif (computerChoice == 'Scissors'):
            result = "LOSE"
            score-=1
        
        print("You chose " + userChoice)
        print("Computer chose " + computerChoice)
        print ("YOU "+ result)


    elif (userChoice == 'Scissors'):
        if (computerChoice == 'Rock'):
            result = "LOSE"
            score-=1
        elif (computerChoice =='Paper'):
            result = "WIN"
            score+=1
        elif (computerChoice == 'Scissors'):
            result = "DRAW"
    
        print("You chose " + userChoice)
        print("Computer chose " + computerChoice)
        print ("YOU "+ result)
    
    elif (userChoice == 'Quit'):
        wantsToPlay = False;
        break;

    else:
        print("Invalid entry. Please try again.")
        
print ("Program ended")
print ("Your score was : " + str(score))