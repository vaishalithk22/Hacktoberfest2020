###########################################

## Author : Divyesh Mehta
## Type : Algorithm
## Name : Dining Philosopher Problem
## Language : Python

###########################################

#This program is an implementation of Dining Philosopher Problem

import threading
import random
import time

class Philosopher(threading.Thread):
    process = True

    def __init__(self, name, rfork, lfork):
        threading.Thread.__init__(self)
        self.name = name
        self.lfork = rfork
        self.rfork = lfork

    def run(self):
        while (self.process):
            time.sleep(random.uniform(1, 10))
            print("{} is hungry".format(self.name))
            self.eat()

    def eat(self):
        fork1, fork2 = self.lfork, self.rfork

        while self.process:
            fork1.acquire(True)
            locked = fork2.acquire(False)
            if locked:
                break
            fork1.release()
            print("{} is swapping forks".format(self.name))
            fork1, fork2 = fork2, fork1
        else:
            return

        self.eating()
        fork2.release()
        fork1.release()

    def eating(self):
        print("{} starts eating".format(self.name))
        time.sleep(random.uniform(1, 10))
        print("{} started thinking".format(self.name))


def DiningPhilosophers():
    forks = [threading.Lock() for n in range(5)]
    philosopher_names = ['Binod', 'Rashi', 'Gopi', 'Riya', 'Mike']

    philosophers = [Philosopher(philosopher_names[i], forks[i % 5], forks[(i + 1) % 5]) \
                    for i in range(5)]

    random.seed(100)
    Philosopher.process = True
    for p in philosophers:
        p.start()
    time.sleep(100)
    Philosopher.process = False
    print("Process Finished :)")
    return

DiningPhilosophers()
