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
        /* Your Code Here */
        let newNode=new Node(arr[0]);
        this.head = newNode;
        var runner = this.head;

        for(var i=1; i < arr.length; i++){
            let newerNode=new Node(arr[i]);
            this.next = newerNode;
        }
        runner.next=newNode;
        return list;
    }
};

let test_data1=123;
let test_data2=234;
let test_data6=678;
let test_data3=345;
let test_data4=[111,222,333,444,555];
let test_data5=[666,777,888,999,1010];

/* Create our list */
let list=new List();


/* Is it empty: */
// console.log(list.IsEmpty());

/* Insert nodes into the list: */
// list.PushBack(test_data1);
// list.PushBack(test_data2);
// list.PushBack(test_data3);

/* Insert array of nodes into the list: */
console.log(list.PushBackN(test_data4));

// console.log(list.PushBackN(test_data5));

/* Iterate our list, so we can see our node values */
// list.Iterate(value=>console.log(value));