class Node{
    constructor(value){
        this.value=value;
        this.next=undefined;
    }
};

class List {
    constructor(){
        this.head=undefined;
    }

    IsEmpty(node){
        if(this.head === undefined){
            return "empty";
        }else{
            return "Has values";
        }
    }

    /**
     * Creates a new node with the given data and inserts that node at the front
     * of this list.
     * @param {any} data The data for the new node.
     * @returns {SinglyLinkedList} This list.
     */
    
    insertAtFront(value) {
        let newNode = new Node(value);
        if(this.head === null){
            newNode = this.head;
        }else{
            var temp = this.head;
            this.head = newNode;
            this.head.next = temp;
        }
    }

    /**
     * Removes the first node of this list.
     * @returns {any} The data from the removed node.
     */
    removeHead() {
        let temp = this.head;
        this.head = this.head.next.next;
        temp.next = null;
    }

    // EXTRA
    /**
     * Calculates the average of this list.
     * @returns {number|NaN} The average of the node's data.
     */
    average() {
        var runner = this.head;
        var sum = 0, ct = 0;
        while(runner.next != null){
            sum += runner.value;
            runner = runner.next;
            ct++;
        }

        return sum / ct;
    }

    PushBack(value){
        let newNode=new Node(value);

        if(this.head === undefined){
            this.head = newNode;
        }else{
            var runner = this.head;

            while(runner.next != null){
                runner = runner.next;
            }

            runner.next=newNode;
        }
        return value;
    }

    PushBackN(arr){
        let newNode=new Node(arr[0]);
        var runner;
        
        if(this.head === undefined){
            this.head = newNode;
            runner = this.head;
        }else if(this.head.next === null){
            let newNewNode =new Node(arr[0]);
            this.head.next = newNewNode;
        }else{
            runner = this.head;
            while(runner.next != null){
                runner = runner.next;
            }
        }

        for(var i=0;i < arr.length; i++){
            let anotherNewNode =new Node(arr[i]);
            runner.next = anotherNewNode;
            runner = runner.next;
        } 
    }

    //REMOVE BACK
    removeBack(){
        var runner = this.head;
        var pervious = runner;
        while(runner.next != null){
            pervious = runner;
            runner = runner.next
        }
        pervious.next = null;
    }

    // CONTAINS
    contains(val) {
        var runner = this.head;
        while(runner != null){
            if(runner.value === val){

                return "Found you!!";
            }
            runner = runner.next;
        }
        return "Booooooo";
    }

    // CONTAINSRECURSIVE
    containsRecursive(val, current = this.head){
        if(current.value === val){
            return "Mic drop!";
        }else{
            if(current.next != null){
                return this.containsRecursive(val, current.next);
            }else{
                return "Bummer...better luck next time";
            }
        }
    }

    secondToLast(){
        var runner = this.head;
        while(runner.next.next != null){
            runner = runner.next;
        }
        return runner.value;
    }

    removeValue(val){
        // 678
        var runner = this.head;
        var pervious = runner;

        while(runner.next != null){
            if(this.head.value === val){
                //checks first
                var temp = this.head;
                this.head = this.head.next;
                temp.next = null;
                break;
            }else if(runner.value === val){
                // middle values
                var temp = runner.next;
                runner.next = null;
                pervious.next = temp;
                break;
            }
            pervious = runner;
            runner = runner.next;
        }
        //checks last 
        if(runner.value === val){
            pervious.next = null;
        }
    }

    prepend(val,newVal){
        let newNode=new Node(newVal);
        var runner = this.head;
        var pervious = runner;
        
        while(runner.next != null){
            if(this.head.value === val){
                //checks first
                var temp = runner;
                this.head = newNode;
                newNode.next = temp;
                break;
            }else if(runner.value === val){
                // middle values
                var temp = runner;
                pervious.next  = newNode;
                newNode.next = runner;
                break;
            }
            pervious = runner;
            runner = runner.next;
        }

        //checks last 
        if(runner.value === val){
            var temp = runner;
            pervious.next = newNode;
            newNode.next = temp;
        }
    }

    // LOOP THROUGH AND SHOW ALL VALUES
    showValues(){
        var runner = this.head;
        while(runner != null){
            console.log(runner.value);
            runner = runner.next;
        }
    }
}

let test_data1=123;
let test_data2=234;
let test_data3=345;
let test_data4=456;
let test_data5=567;
let test_data6=678;
let test_data7=[111,222,333,444,555];
let test_data8=[666,777,888,999,1010];

let list = new List();

// === MONDAY ===
    // IS EMPTY
    // console.log(list.IsEmpty());

//ADD TO BACK
// list.PushBack(test_data3);
// list.PushBack(test_data2);

// ADD ARRAY
// list.PushBackN(test_data7);
// list.PushBackN(test_data8);


// ADD TO FRONT
list.insertAtFront(test_data1);
list.insertAtFront(test_data2);
list.insertAtFront(test_data3);
list.insertAtFront(test_data4);
list.insertAtFront(test_data5);
list.insertAtFront(test_data6);

// === TUESDAY ===
    // REMOVE HEAD
    // list.removeHead();

    // AVERAGE
    // console.log("Average: " + list.average());

// === WEDNESDAY ===
    // REMOVE FROM BACK
    // list.removeBack();

    // CONTAINS
    // console.log(list.contains(678));

    // CONTAINSRECURSIVE
    // console.log(list.containsRecursive(222));

// === THURSDAY ===
    // GET SECOND TO LAST
    // console.log("Second to last: " + list.secondToLast());

    // REMOVE VALUE
    // list.removeValue(567);
    // list.removeValue(678);
    // list.removeValue(123);

    // PREPEND
    // list.prepend(345,111);
    // list.prepend(678,111);
    list.prepend(123,111);
    list.showValues();

// SHOW VALUES IN LINKED LIST


// recursively reverse your list in place