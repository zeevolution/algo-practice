// -- Problem's Formulation
// 1 - Create a node class. The constructor
// should accept an argument that gets assined
// to the data property and initialize an
// empty array for storing children. The node
// class should have methods 'add' and 'remove'.
// 2 - Create a tree class. The three constructor
// should initialize a 'root' property to null.
// 3 - Implement 'traverseBFS' and 'traverseDFS'
// on the tree class.

class Node {
  constructor(data) {
    this.data = data;
    this.children = [];
  }

  add(data) {
    this.children.push(new Node(data));
  }

  remove(data) {
    this.children = this.children.filter(element => element.data !== data);
  }
}

class Tree {
  constructor() {
    this.root = null;
  }

  traverseBF(fn) {
    let arr = [this.root];

    while (arr.length) {
      const node = arr.shift();
      arr.push(...node.children);
      fn(node);
    }
  }

  traverseDF(fn) {
    let arr = [this.root];

    while (arr.length) {
      const node = arr.shift();
      arr.unshift(...node.children);
      fn(node);
    }
  }
}

module.exports = { Node, Tree };
