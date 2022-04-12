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

    // EMPTY
    isEmpty() {
        if(this.root === null){
            return true;
        }
        return false;
    }

    // MIN
    min(current = this.root){
        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }

    // MAX
    max(current = this.root) {
        while(current.right != null){
            current = current.right;
        }
        return current.data;
    }

    // minRecursive
    minRecursive(current = this.root){
        while(current.left != null){
            return this.minRecursive(current = current.left);
        }
        return current.data;
    }

    maxRecursive(current = this.root) {
        while(current.right != null){
            return this.maxRecursive(current = current.right);
        }
        return current.data;
    }

    // CONTAINS
    contains(searchVal){
        if(this.root === null){
            return "empty";
        }else{
            var runner = this.root;
            while(runner.left != null || runner.right != null){
                if(searchVal === runner.data) {
                    return "Found You!!";
                }else if(searchVal < runner.data){
                    runner = runner.left;
                }else if(searchVal > runner.data){
                    runner = runner.right;
                }
                return "You loose, value not found";
            }
        }
    }

    // CONTAINSRECURSIVE
    containsRecursive(searchVal, current = this.root) {
        if(this.root === null){
            return "empty";
        }else{
            if(current == null){
                return "You fail, number can't be found...";
            }else if(current.data === searchVal){
                return "Found You!!";
            }else if( searchVal > current.data){
                return this.containsRecursive(searchVal,current = current.right);
            }else if(searchVal < current.data){
                return this.containsRecursive(searchVal,current = current.left);
            }
        }
    }

    range(startNode = this.root){
        var min = this.minRecursive(startNode);
        var max = this.maxRecursive(startNode);
        return `min: ${min} : max ${max}`;
    }

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
        // console.log(emptyTree.isEmpty());
// 
    //Inserts values
    const oneNodeTree = new BinarySearchTree();
        oneNodeTree.root = new BSTNode(10);
        // oneNodeTree.insert(15);
        // oneNodeTree.insert(5);

/* twoLevelTree
            root
            10
          /   \
        5     15
  */

    const twoLevelTree = new BinarySearchTree();
        // twoLevelTree.root = new BSTNode(10);
        // twoLevelTree.root.left = new BSTNode(5);
        // twoLevelTree.root.right = new BSTNode(15);
            //console.log(twoLevelTree);
        
/* threeLevelTree 
          root
          10
        /   \
      5     15
    / \    / \
  2   4  13  20
  */

const threeLevelTree = new BinarySearchTree();
    // threeLevelTree.root = new BSTNode(10);
        // threeLevelTree.root.left = new BSTNode(5);
        // threeLevelTree.root.left.left = new BSTNode(2);
    
    // threeLevelTree.root.left.right = new BSTNode(4);

    // threeLevelTree.root.right = new BSTNode(15);
    // threeLevelTree.root.right.right = new BSTNode(20);
    // threeLevelTree.root.right.left = new BSTNode(13);

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
const fullTree = new BinarySearchTree();
    fullTree.insert(25);
    fullTree.insert(15);
    fullTree.insert(10);
    fullTree.insert(22);
    fullTree.insert(4);
    fullTree.insert(12);
    fullTree.insert(18);
    fullTree.insert(24);
    fullTree.insert(50);
    fullTree.insert(35);
    fullTree.insert(70);
    fullTree.insert(31);
    fullTree.insert(44);
    fullTree.insert(66);
    fullTree.insert(90);
    
    // ========= MONDAY =========
    // fullTree.print();
        //FIND MIN
        // console.log(fullTree.min());
        
        //FIND MIN
        // console.log(fullTree.max());

        // FIND MINRECURSION
        // console.log(fullTree.minRecursive());

        // FIND MAXRECURSION
        // console.log(fullTree.maxRecursive());
    
    // ========= TUESDAY =========
    // fullTree.print();
        // CONTAINS
        // console.log(fullTree.contains(100));

        // CONTAINSRECURSIVE
        // console.log(fullTree.containsRecursive(100));

        // RANGE

        console.log(fullTree.range());
