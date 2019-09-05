# Straight Facts'orials

We took two different approaches to thinking over the efficiency of
what we discovered was ultimately Heap's algorithm, which we have 
sourced from a Geeks for Geek's page. The first is our attempt at a
more mathemtical approach then what we understood was actually asked.
The second approach is moreso what was asked, which was determining the
efficiency based on printed lines. Let's start with the math approach.

## Math Approach
The TCRC book defines factorials like:
### 3rd Ed Alg Book's Factorial Definition
Θ(n!) = {

    1                                 if n = 0
    n * (n-1)!                        if n > 0
}

And Heap (as we see it) be all like:
### GfG Heap's Alg (as we see it)
Θ(n!) = {

    sout(Arrays.toString(arr))        (if n == 1)
    algo(n-1) * algo((n-1) - 1)!      (if n > 1)
   
}

As you can see, somehow the math vs csci distinction of where to start
counting is somehow reversed, with the base case starting at 1 and
not 0. The base case is just printing out the array of values as they
are. The factorial case has two parts. The first half, `algo(n-1)` is
the `[outer]` recursive call inside `algo()`. It is multiplied by
`algo((n-1) - 1)!` (the `[inner]`) because inside of each callback to 
`[outer]` is `(n-1)!` calls to `algo()` itself, in effect, `n - 1 - 1` calls, factorial times.

Now for the printed lines approach.

## Printed Lines

In terms of printed lines, we discovered on day one of the the lab that
the amount of unique orderings was number of digits factorial. Each
line that is printed by the Heap's algorithm is one unique ordering of
N numbers. Thus in effect, because it produces N! lines, from a printed
lines perspective on efficiency, the Big-O of it is factorial. This
lines up with our semi-handwavey math explanation. 

For n = 4, there are 4! lines, aka 24. For n = 5, 120 lines.

## Predicting time for values of n

In order to predict the time for different values of n, it may be 
helpful for us to have some sample time to start with. The code file
has comments near the bottom of some trials that were run with levels of
n = 1 to n = 11. 

To predict for n = 15 and n = 20, we can use properties of factorial to
estimate run times. The runtime for n = 11 was 388463 milliseconds.
We estimate that running for n=15 will be about 15*14*13*12* the runtime
for n = 11. (about 12726047880 milliseconds or 3535 hours).

Going further, the run time for n = 20 will be about 20*19*18*17*16* the
runtime for n = 15 (about 6576796800 hours or about 750775 years).
