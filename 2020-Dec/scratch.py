
class Animal():
    def __init__(self):
        self.is_animal = True

    def speak(self):
        print("generic sound")


class Dog(Animal):
    def speak(self):
        print("woof")
