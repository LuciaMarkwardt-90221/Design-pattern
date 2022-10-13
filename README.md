# Design-pattern

This is a simple javafx application of 3 balls, Black,Red and Blue
They have different behaviours
Instead of implement them as separate classes, I implement the movement via strategy, each colour has a strategy
So that in later process, if you wanna add new balls, there is no need to change the code of balls and redo everything, simply add a new strategy
Open/Closed Principle is satisfied
