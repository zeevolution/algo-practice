// -- Problem's Formulation
// Given the root node of a tree, return
// an array where each element is the width
// of the tree at each level.
// -- e.g.:
// Given:
//     0
//   / |  \
// 1   2   3
// |       |
// 4       5
// Answer: [1, 3, 2]

function levelWidth(root) {
  let counters = [0];
  let arr = [root, "l"];

  while (arr.length > 1) {
    const node = arr.shift();
    if (node === "l") {
      counters.push(0);
      arr.push("l");
    } else {
      arr.push(...node.children);
      counters[counters.length - 1]++;
    }
  }

  return counters;
}

module.exports = levelWidth;
