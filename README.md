# fccode

A CLI that creates multiplication tables of n primes. Handy for party tricks.
Built in Clojure.

## Installation

Clone this repo or download the fccode-0.1.0-standalone.jar.

## Usage

Install Java if you don't have it already: https://www.java.com/en/download/.
Run the JAR. 

    $ java -jar fccode-0.1.0-standalone.jar
    
Optionally specify the desired number of primes (results not guaranteed above 3000).
    
    $ java -jar fccode-0.1.0-standalone.jar n

Negative or decimal inputs will be judiciously ignored.

## Examples

For 3 primes:

    $ java -jar fccode-0.1.0-standalone.jar 3
    
    1 2 3
    2 4 6
    3 6 9
   
Without any input, the default is 10 primes: 
    
    $ java -jar fccode-0.1.0-standalone.jar
    
    1 2 3 5 7 11 13 17 19 23
    2 4 6 10 14 22 26 34 38 46
    3 6 9 15 21 33 39 51 57 69
    5 10 15 25 35 55 65 85 95 115
    7 14 21 35 49 77 91 119 133 161
    11 22 33 55 77 121 143 187 209 253
    13 26 39 65 91 143 169 221 247 299
    17 34 51 85 119 187 221 289 323 391
    19 38 57 95 133 209 247 323 361 437
    23 46 69 115 161 253 299 391 437 529



### Issues

The usability issues of reading a large table far outpace the limitations of the algorithm used to generate prime numbers. Basically, a human will find this useless before a computer runs into problems generating it.

+ The table becomes difficult to scan once the products have multiple digits. Adding spacing to right-align values within columns would be great.
+ The table is unusable once the columns expand beyond the width of the output and begin wrapping on new lines.
+ A StackOverflow error occurs for requests somewhere above 3000 primes.
+ Create tests for the `filter-primes` function for cases of 0 and negative numbers.
+ The CLI experience could be improved with a dedicated command instead of using java -jar.