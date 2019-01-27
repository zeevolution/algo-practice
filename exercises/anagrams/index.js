// -- Problem`s Formulation
// Check to see if two provided strings are anagrams of each other.
// One string is an anagram of another if it uses the same characters
// in the same quantity. Only consider characters, not spaces
// or punctuation. Consider capital letters to be the same as lower cases.
// -- e.g.:
// anagrams('rail safety', 'fairy tales') --> True
// anagrams('RAIL! SAFETY!', 'fairy tales') --> True
// anagrams('Hi there', 'Bye there') --> False

function anagrams(stringA, stringB) {
  /**
   * Solution #1: Using Object Mapping and for looping
   */
  /**
  let anagram = false;
  if (stringA.length === stringB.length) {
    const filteredStringA = stringA.replace(/[^\w]/g, "").toLowerCase();
    const filteredStringB = stringB.replace(/[^\w]/g, "").toLowerCase();
    const charMapA = [];
    const charMapB = [];

    for (let char of filteredStringA) {
      if (charMapA[char]) {
        charMapA[char]++;
      } else {
        charMapA[char] = 1;
      }
    }

    for (let char of filteredStringB) {
      if (charMapB[char]) {
        charMapB[char]++;
      } else {
        charMapB[char] = 1;
      }
    }

    for (let keyA in charMapA) {
      for (let keyB in charMapB) {
        if (keyA === keyB) {
          if (charMapA[keyA] === charMapB[keyB]) {
            anagram = true;
          } else {
            return false;
          }
        }
      }
    }

    return anagram;
  } else {
    return anagram;
  }
  */

  //----------------------------------------------------

  /**
   * Solution #2: Using Object Mapping, for looping and
   * helper function
   */
  const aCharMap = buildCharMap(stringA);
  const bCharMap = buildCharMap(stringB);
  if (Object.keys(aCharMap).length !== Object.keys(bCharMap).length) {
    return false;
  }
  for (let char in aCharMap) {
    if (aCharMap[char] !== bCharMap[char]) {
      return false;
    }
  }
  return true;

  //----------------------------------------------------

  /**
   * Solution #3: Using array's helper sort and join
   */
  //return cleanString(stringA) === cleanString(stringB);
}

/**
 * Helper function for mapping a string to { char: quantity }
 * @param {String} str
 */
function buildCharMap(str) {
  const charMap = {};

  for (let char of str.replace(/[^\w]/g, "").toLowerCase()) {
    charMap[char] = +1 || 1;
  }

  return charMap;
}

/**
 * Clean a string by splitting it, sorting the elements
 * and joining them back.
 *
 * @param {String} str
 */
function cleanString(str) {
  return str
    .replace(/[^\w]/g, "")
    .toLowerCase()
    .split("")
    .sort()
    .join("");
}

module.exports = anagrams;
