// -- Problem's Formulation
// Given a string, return true if the string is a palindrome
// or false if it not. Palindromes are string that
// form the same word if it is reversed. *Do* include spaces
// and punctuation in determining if the string is a palindrome.
// -- e.g.:
// palindrome("abba") === true
// palindrome("abcdefg") === false

function palindrome(str) {
  /**
   * Solution #1: Using Array.prototype.reverse
   */
  //return (
  //  str
  //    .split("")
  //    .reverse()
  //    .join("") === str
  //);

  // ------------------------------------------

  /**
   * Solution #2: Using for loop
   */
  //let reversed = "";
  //for (let character of str) {
  //  reversed = character + reversed;
  //}
  //return reversed === str;

  // ------------------------------------------

  /**
   * Solution #3: Using the reduce helper
   */
  //return str.split("").reduce((rev, char) => char + rev, "") === str;

  // ------------------------------------------

  /**
   * Solution #4: Using the every helper
   */
  return str.split("").every((char, i) => {
    return char === str[str.length - i - 1];
  });
}

module.exports = palindrome;
