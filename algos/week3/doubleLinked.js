class Node{
    constructor(value){
        this.value = value;
        this.next = undefined;
        this.pre = undefined;
    }
}

class List{
    constructor(){
        this.head = undefined;
        this.tail = undefined;
    }

    IsEmpty(node){
        if(this.head === undefined && this.tail === undefined){
            return "No nodes :(";
        }
        return "Nodes! Nodes! Nodes!";
    }

    AddToFront(value){
        var newNode = new Node(value);

        if(this.head === undefined){
            // 1 num
            this.head = newNode;
            this.tail = newNode;
            newNode.next = null;
            newNode.pre = null;
        }else{
            var temp = this.head;
            this.head = newNode;
            newNode.next = temp;
            newNode.pre = null;
            temp.pre = newNode;
        }
    }

    addToBack(value){
        var newNode = new Node(value);

        if(this.head === undefined){
            // 1 num
            this.head = newNode;
            this.tail = newNode;
            newNode.next = null;
            newNode.pre = null;
            return;
        }else{
            var temp = this.tail;

            this.tail = newNode;
            newNode.pre = temp;
            newNode.next = null;
            temp.next = newNode

            return;
        }
    }

    removeMiddleNode(value) {
        //front
        if(this.head.value === value){
            var temp = this.head.next;
            this.head.next = null;

            this.head = temp;
            this.head.pre = null;
        }else if(this.tail.value === value){
            //back
            var temp = this.tail.pre;
            this.tail.pre = null;

            this.tail = temp;
            temp.next = null;
        }else{
            //middle
            var runner = this.head;
            while(runner.next != null){
                if(runner.value === value){
                    var temp = runner.next;
                    var tempPre = runner.pre;
                    runner.next = null;
                    runner.pre = null;
                    temp.pre = tempPre
                    tempPre.next = temp;                    
                    return;
                }
                runner = runner.next;
            }
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
}

/* Create our list */
let list=new List();
    // values
    let test_data1=123;
    let test_data2=234;
    let test_data3=345;
    let test_data4=456;
    let test_data5=567;

    //EMPTY
    
    // ADD TO BACK
    list.addToBack(test_data1);
    list.addToBack(test_data2);
    list.addToBack(test_data3);
    list.addToBack(test_data4);
    list.addToBack(test_data5);
    console.log(list.IsEmpty());
            // list.iterate(list);

    // ADD TO FRONT
        // list.AddToFront(test_data1);
        // list.AddToFront(test_data2);
        // list.AddToFront(test_data3);
        // list.AddToFront(test_data4);
        // list.AddToFront(test_data5);
            list.iterate(list);
    
    // removeMiddleNode
        list.removeMiddleNode(456);
        console.log(" ===================== ");
        list.iterate(list);