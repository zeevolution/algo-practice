// -- Problem's Formulation
// Write a program that console logs the numbers
// from 1 to n. But for multiples of three print
// "fizz" instead of the number and for multiples
// of five print "buzz". For numbers which are multiples
// of both three and five print "fizzbuzz"
// -- e.g.:
// fizzBuzz(5);
// 1
// 2
// fizz
// 4
// buzz

function fizzBuzz(n) {
  /**
   * Solution 1#:
   */

  for (let i = 1; i <= n; i++) {
    // Is the number a multiple of three and five?
    if (i % 3 === 0 && i % 5 === 0) {
      console.log("fizzbuzz");
    } else if (i % 3 === 0) {
      // Is the number a multiple of three?
      console.log("fizz");
    } else if (i % 5 === 0) {
      // Is the number a multiple of five?
      console.log("buzz");
    } else {
      // Is the number non a multiple of three neither five?
      console.log(i);
    }
  }
}

module.exports = fizzBuzz;
