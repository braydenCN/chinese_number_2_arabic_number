Auther: Brayden Zhang. pczhang2010@gmail.com

Solution to a common problem: how to convert a Chinese number to corresponding
Arabic number. 

This problem is interesting because numbers in Chinese is really "unnormalized".
Instead of "one-ten", it will just be "ten"(but it will be two-ten, three-ten, 
one-hundred, etc.); instead of "one-thousand-one-ten", it will be 
"one-thousand-zero-one-ten"; instead of "one-hundred-one-ten", it will be 
"one-hundred-one".

My solution is first to normalize Chinese number, after that, the convert 
process will be much cleaner.
