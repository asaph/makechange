Make Change
=

This problem makes a good programming excercise or interview question for candidate programmers. It goes
like this:

Write a function that determines the change due to a customer in a cash transaction. The function
has 2 inputs: the cost of the item, and the amount tendered. The output should specify how many of each
denomination should be given to the customer and the answer should be optimal, meaning a minimum number
of coins and/or bills should be given.

As an example, suppose an item costs $9.37 and the customer gives the cashier a $10 bill. The change due
is 63 cents, which should be given as 2 quarters, 1 dime and 3 pennies, a total of 6 coins. An example
of an non-optimal answer in this case would be 6 dimes and 3 pennies (a total of 9 coins).

Bonus - Don't read this until you've solved the above problem.
-

Imagine that instead of the standard American style coin denominations of quarters, dimes, nickels
and pennies, your function is needed in a country that uses coins in the following denominations:
6, 5, 4, 1. Using these denominations, suppose the cost of an item is $9.91 and the customer gives
the cashier a $10 bill. The change due is 9 cents. The optimal solution in this case is to give the
customer a 5 cent coin and a 4 cent coin (just 2 coins). A non-optimal solution would be a 6 cent
coin and three 1 cent coins (4 coins total). Does the algorithm you produced in the first part of
the question produce the optimal result for these coin denominations? If not, why not? Can you
write an algorithm that works for these denominations? Any denominations? 
