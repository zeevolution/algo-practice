// -- Problem's Formulation
// Write a function that returns the number of vowels
// used in a string. Vowels are the characters 'a', 'e'
// 'i', 'o', and 'u'.
// --- e.g.:
//   vowels('Hi There!') --> 3
//   vowels('Why do you ask?') --> 4
//   vowels('Why?') --> 0

function vowels(str) {
  /**
   * Solution #1: Using a iterative solution with includes helper
   */
  let count = 0;
  const vowelsChecker = ["a", "e", "i", "o", "u"];

  for (let char of str.toLowerCase()) {
    if (vowelsChecker.includes(char)) {
      count++;
    }
  }

  return count;

  //------------------------------------------------

  /**
   * Solution #2: Using a regular expression solution
   */
  //const matches = str.match(/[aeiou]/gi);
  //return matches ? matches.length : 0;
}

module.exports = vowels;
