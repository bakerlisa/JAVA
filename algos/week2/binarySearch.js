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


    /**
        [25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90]
    */
    toArrPreorder(node = this.root, vals = []) {
        if(this.root === null){
            return "empty";
        }else{
            var runnerLeft = node.left;
            var runnerRight = node.right;

            vals.push(node.data);
            vals.push(node.left.data);
            vals.push(node.right.data);
                
            while(runnerLeft.left != null || runnerRight.right != null){
            
                if(runnerLeft.data  != null){
                    vals.push(runnerLeft.data);
                    vals.push(runnerLeft.left.data);
                    vals.push(runnerLeft.right.data);
                }
                if(runnerRight.data != null){
                    vals.push(runnerRight.data);
                    vals.push(runnerRight.left.data);
                    vals.push(runnerRight.right.data);
                }
                runnerLeft = runnerLeft.left;
                runnerRight = runnerRight.right;
            } 
        }
        console.log(vals);
        return vals;
    }


    //  [4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90]
    toArrInorder(node = this.root, vals = []) {
        if(this.root === null){ return "empty";}

            var runnerLeft = node.left;
            var runnerRight = node.right;
                
            while(runnerLeft.left != null || runnerRight.right != null){
                if(runnerLeft.data  != null){
                    vals.push(runnerLeft.left.data);
                    vals.push(runnerLeft.data);
                    vals.push(runnerLeft.right.data);
                }
                if(runnerRight.data != null){
                    vals.push(runnerRight.left.data);
                    vals.push(runnerRight.data);
                    vals.push(runnerRight.right.data);
                }
                runnerLeft = runnerLeft.left;
                runnerRight = runnerRight.right;
            } 

        // vals.push(this.root.data);
        

        console.log(vals); 
        return vals;
    }
    
    // [25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]
    toArrLevelorder(node = this.root) {
        var  arr = [];
        arr.push(this.root.data);
        arr.push(this.root.left.data);
        arr.push(this.root.right.data);

        var leftNode = this.root.left;
        var rightNode = this.root.right;

        while(leftNode != null){
            if(leftNode.left != null){
                arr.push(leftNode.left.data);
            }
            if(leftNode.right != null){
                
                arr.push(leftNode.right.data);
            }
            if(rightNode.left != null){
                arr.push(rightNode.left.data);
                
            }
            if(rightNode.right != null){
                arr.push(rightNode.right.data);
            }

            leftNode = leftNode.left;
            rightNode = rightNode.right;
        }


        
        

        
        console.log(arr);
    }

    // Size
    size(node = this.root) {
        var total = 0;

        while(node != null){
            total++;
            node = node.left;
        }

        node = this.root;
        while(node != null){
            total++;
            node = node.right;
        }
        return total;
    }

    //Height - which is
    height(node = this.root) {
        var right=0;
        var left=0;

        while(node != null && node.right != null && node.left != null){
            left++;
            node = node.left;
        }

        node = this.root;
        while(node != null && node.right != null && node.left != null){
            right++;
            node = node.right;
        }
        if(right === left){
            return "You're a full tree!!!!";
        }else if(right > left){
            return `Left is taller ${left}`;
        }else if(right < left){
            return `Right is taller ${right}`;
        }
    }

    // full Tree
    isFull(node = this.root) {
        var right=0;
        var left=0;

        while(node != null ){
            left++;
            node = node.left;
        }

        node = this.root;
        while(node != null){
            right++;
            node = node.right;
        }

        if(right === left){
            return "Congrats you are a full tree, what will you do next?";
        }else{
            return "**Buzzer** Yooooooou're out!";
        }
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
    // fullTree.insert(100);
    
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
        // console.log(fullTree.range());
    
    // ========= Wednesday =========
        // fullTree.printTree();
        // fullTree.print();

    // ========= THURSDAY =========
        // fullTree.toArrPreorder();
        // fullTree.toArrInorder();
        // fullTree.print();

    // ========= FRIDAY =========
        fullTree.print();
        // console.log(fullTree.size());
        // console.log(fullTree.height());
        // console.log(fullTree.isFull());
        console.log(fullTree.toArrLevelorder());



    // printTree(){
        // if(this.root === null){return false}

        // console.log(this.printTree(this.root.data));
        // var right = this.root;
        // var left = this.root;

        // if(this.root != null){
        //     console.log("      " + this.root.data + "   " );
        // }

        // if(left.left != null || right.right != null){    
        //     console.log(left.left.data + "          "  + right.right.data );
        // }

        // while(left.left != null){
        //     console.log(left.left.data + "          "  + left.right.data );
        //     left = left.left;
        // }

        // while(right.right != null){
        //     console.log(right.left.data + "          "  + right.right.data );
        //     right = right.right;
        // }
    // }