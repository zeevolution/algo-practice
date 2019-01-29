// -- Problem's Formulation
// Print out the n-th entry in the fibonacci series.
// The fibonacci series is an ordering of numbers where
// each number is the sum of the preceeding two.
// -- e.g.:
// [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
// forms the first ten entries of the fibonacci series.
// -- e.g.:
// fib(4) === 3

//function fib(n) {
/**
 * Solution #1: Iterative Solution. Linear Runtime Complexity. O(n)
 */
//const results = [0, 1];

//for (let i = 2; i <= n; i++) {
//  const a = results[i - 1];
//  const b = results[i - 2];

//  results.push(a + b);
//}

//return results[n];

/**
 * Solution #2: Recursive Solution. Exponential Runtime Complexity. O[2 ^ n].
 * Real bad as the series numbe n increases.
 */
//if (n < 2) {
//  return n;
//}

//return fib(n - 1) + fib(n - 2);
//}

/**
 * Caching the function calls
 * @param {*} fn
 */
function memoize(fn) {
  const cache = {};
  return function(...args) {
    if (cache[args]) {
      return cache[args];
    }

    const result = fn.apply(this, args);
    cache[args] = result;

    return result;
  };
}

function slowFib(n) {
  if (n < 2) {
    return n;
  }

  return fib(n - 1) + fib(n - 2);
}

const fib = memoize(slowFib);

module.exports = fib;
