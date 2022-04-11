/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
class BSTNode {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/**
   * Represents an ordered tree of nodes where the data of left nodes are <= to
   * their parent and the data of nodes to the right are > their parent's data.
   */
class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    insert (newVal) {
        const node = new BSTNode(newVal)

        if (this.isEmpty()) {
            this.root = node
            return this
        }

        let current = this.root

        while (true) {
            if (newVal <= current.data) {
            if (!current.left) {
                current.left = node
                return this;
            }

            current = current.left
            } else {
            // newVal is greater than current.data
            if (!current.right) {
                current.right = node
                return this;
            }

            current = current.right
            }
        }
    }

    isEmpty() {
        if(this.root === null){
            return true;
        }
        return false;
    }

    min(current = this.root){
        return current.left.data;
    }

    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    minRecursive(current = this.root) {}

    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    max(current = this.root) {
        return current.right.data;
    }

    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    maxRecursive(current = this.root) {}

    // Logs this tree horizontally with the root on the left.
    print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
        if (!node){ return }
        spaceCnt += spaceIncr;
        this.print(node.right, spaceCnt);

        console.log(" ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) + `${node.data}`);

        this.print(node.left, spaceCnt);
    }
}

// ====== MONDAY ======
    // IS EMPTY
    const emptyTree = new BinarySearchTree();
        console.log(emptyTree.isEmpty());
// 
    //Inserts values
    const oneNodeTree = new BinarySearchTree();
        oneNodeTree.root = new BSTNode(10);
        oneNodeTree.insert(15);
        oneNodeTree.insert(5);

    //FIND MIN
    // console.log(oneNodeTree.min());

    // FIND MAX
    // console.log(oneNodeTree.max());


/* twoLevelTree
          root
          10
        /   \
      5     15
  */

    const twoLevelTree = new BinarySearchTree();
    twoLevelTree.root = new BSTNode(10);
    twoLevelTree.root.left = new BSTNode(5);
    twoLevelTree.root.right = new BSTNode(15);
    console.log(twoLevelTree);
    
/* threeLevelTree 
          root
          10
        /   \
      5     15
    / \    / \
  2   4  13  20
  */

const threeLevelTree = new BinarySearchTree();
    threeLevelTree.root = new BSTNode(10);
    threeLevelTree.root.left = new BSTNode(5);
    threeLevelTree.root.left.left = new BSTNode(2);
    threeLevelTree.root.left.right = new BSTNode(4);
    threeLevelTree.root.right = new BSTNode(15);
    threeLevelTree.root.right.right = new BSTNode(20);
    threeLevelTree.root.right.left = new BSTNode(13);

  /* fullTree
                      root
                  <-- 25 -->
                /            \
              15             50
            /    \         /    \
          10     22      35     70
        /   \   /  \    /  \   /  \
      4    12  18  24  31  44 66  90
  */
  /***************** Uncomment after insert method is created. ****************/
  // const fullTree = new BinarySearchTree();
  // fullTree
  //   .insert(25)
  //   .insert(15)
  //   .insert(10)
  //   .insert(22)
  //   .insert(4)
  //   .insert(12)
  //   .insert(18)
  //   .insert(24)
  //   .insert(50)
  //   .insert(35)
  //   .insert(70)
  //   .insert(31)
  //   .insert(44)
  //   .insert(66)
  //   .insert(90);