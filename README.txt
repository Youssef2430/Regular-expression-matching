Regular match is an algorithm that lets you make a pattern and then checks the expressions you give afterwards to see if they follow the pattern given.

Rules :
	- Any character between two '*' are words that can be used in any order and any number of times (ex : if given *abcd* the expression aacddb is correct).
	- If a special character needs to be inserted between '*' like for example another '*' you can simply put a '/' before (ex : for the pattern "*abcd/*e*" the expression acb** is correct).
	- For any part of the pattern that needs to exactly the same, you just writes it outside of the two '*' (ex : if the pattern is "*abcd*@gmail.com" then all the expressions given need to end with '@gmail.com').
	- You can combine between stict parts and flexible ones (the ones between two '*') to find the right fit for all your expression !


Thank you !

**** Finished(might add other functionalities) **** 
