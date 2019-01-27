// -- Problem's Formulation
// Given a string, return the character that is the most
// commonly used in the string.
// -- e.g.
// maxChar("abcccccccb") === "c"
// maxChar("apple 1231111") === 1

function maxChar(str) {
  /**
   * Solution #1: Using for loop and a map object.
   */
  const charMap = {};
  let max = 0;
  let maxChar = "";

  for (let char of str) {
    if (charMap[char]) {
      charMap[char]++;
    } else {
      charMap[char] = 1;
    }
  }

  for (let char in charMap) {
    if (charMap[char] > max) {
      max = charMap[char];
      maxChar = char;
    }
  }

  return maxChar;
}

module.exports = maxChar;
