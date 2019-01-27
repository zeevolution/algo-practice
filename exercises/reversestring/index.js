// -- Problem's Explanation
// Given a string, return a new string with the reversed
// order of characters
// -- e.g.
// reverse('apple') === 'leppa'
// reverse('hello') === 'olleh'
// reverse('Greetings!') === '!sgniteerG'

function reverse(str) {
  /**
   * Solution #1: Using Array.prototype.reverse
   */
  //return str
  //  .split("")
  //  .reverse()
  //  .join("");

  // ----------------------------------------- //

  /**
   * Solution #2: Using for loop
   */
  //let reversed = "";

  //for (let character of str) {
  //  reversed = character + reversed;
  //}

  //return reversed;

  // ----------------------------------------- //

  /**
   * Solution #3: Using the reduce helper
   */
  return str.split("").reduce((rev, char) => char + rev, "");
}

module.exports = reverse;
