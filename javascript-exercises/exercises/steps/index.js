// --- Problem's Formulation
// Write a function that accepts a positive number N.
// The function should console log a step shape
// with N levels using the # character. Make sure the
// step has spaces on the right hand side!
// --- e.g.:
//   steps(2)
//       '# '
//       '##'
//   steps(3)
//       '#  '
//       '## '
//       '###'
//   steps(4)
//       '#   '
//       '##  '
//       '### '
//       '####'

function steps(n, row = 0, stair = "") {
  /**
   * Solution #1: Create a Matrix using the for loop
   */
  //for (let row = 0; row < n; row++) {
  //  let stair = "";
  //  for (let column = 0; column < n; column++) {
  //    if (column <= row) {
  //      stair += "#";
  //    } else {
  //      stair += " ";
  //    }
  //  }
  //  console.log(stair);
  //}

  //-----------------------------------------------

  /**
   * Solution #2: Using Recursive Functions
   */
  if (n === row) {
    return;
  }

  if (n === stair.length) {
    console.log(stair);
    return steps(n, row + 1, "");
  }

  const add = stair.length <= row ? "#" : " ";
  steps(n, row, stair + add);
}

module.exports = steps;
