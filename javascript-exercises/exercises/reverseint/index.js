// -- Directions
// Given an integer, return an integer that is the reverse
// ordering of numbers.
// --- e.g.:
// reverseInt(15) === 51
// reverseInt(981) === 189
// reverseInt(500) === 5
// reverseInt(-15) === -51
// reverseInt(-90) === -9

function reverseInt(n) {
  /**
   * Solution #1: Using reduce and Math.sign()
   */
  const reversed = n
    .toString()
    .split("")
    .reduce((rev, char) => char + rev, "");

  return parseInt(reversed) * Math.sign(n);
}

module.exports = reverseInt;
