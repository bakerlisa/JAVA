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

    /* Determine whether the list is empty. */
    IsEmpty(node){
        if(this.head === undefined){
            return "empty";
        }else{
            return "Has values";
        }
    }

    /* Insert a node with the given value to the end of the list */
    PushBack(value){
        let newNode=new Node(value);

        /* Your Code Here */
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

    /* Insert an array of nodes with the given values to the end of the list. */
    PushBackN(arr){
        let newNode=new Node(arr[0]);
        this.head = newNode;
        var runner = this.head;

        /* Your Code Here */
        for(var i=0; i < arr.length; i++){
            
            let newerNode=new Node(arr[i]);
            this.next = newerNode;
        }
        runner.next=newNode;
        return list;
    }

    insertAtFront(value) {
        let newNode = new Node(value);
        var temp = this.head;
        newNode = this.head;
        newNode.next = temp;
    }

    hasLoop(){
        console.log("Here");
    }

    reverse(){
        var runner = this.head.next;
        var walker = this.head;

        if(this.head == null){
            return "empty";
        }

        while(runner != null){
            var temp = runner.next;
            runner.next = walker;

            walker = runner;
            runner = temp;
        }

        this.head.next = null;
        this.head = walker;
    }

    removeNegatives() {
        var runner = this.head;
        var walker = runner;
        var temp;

        //first value
        if(this.head.value < 0){
            temp = this.head;
            this.head = this.head.next;
            temp.next = null;
            return;
        }
        
        // middle number
        while(runner.next != null){
            if(runner.value < 0){
                if(runner.next != null){
                    temp = walker;
                    walker.next = runner.next;
                }
            }
            walker = runner;
            runner = runner.next;
        }

        // last value
        if(runner.value < 0){
            walker.next = null;
        }
    }

    

    iterate(list){
        if(list.head != null){
            var runner = this.head;
            while(runner.next != null){
                console.log(runner.value);
                runner = runner.next;
            }
            console.log(runner.value);
        }
    }
};

let test_data1=123;
let test_data2=234;
let test_data6=678;
let test_data3=-345;
let test_data4=[111,222,333,444,555];
let test_data5=[666,777,888,999,1010];

/* Create our list */
let list=new List();


/* Is it empty: */

/* Insert nodes into the list: */
list.PushBack(test_data1);
list.PushBack(test_data2);
list.PushBack(test_data6);
list.PushBack(test_data3);

//rEVERSE
    // list.iterate(list);
    // console.log(" ==================== ");
    // // list.reverse();
    // list.iterate(list);

//removeNegatives
    list.iterate(list);
    console.log(" ==================== ");
    list.removeNegatives();
    list.iterate(list);

// hasLoop
    // list.iterate(list);
    // console.log(" ==================== ");
    // list.hasLoop();
    // list.iterate(list);


/* Insert array of nodes into the list: */
// list.PushBackN(test_data4);

// console.log(list.PushBackN(test_data5));

/* Iterate our list, so we can see our node values */
