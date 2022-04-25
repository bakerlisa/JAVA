
class StackNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    constructor() {
        this.head = null;
}

}class Stack {
    constructor() {
        this.items = [];
    }

    push(item) {
        return this.items.push(item);
    }

    front(item){
        return this.items.unshift(item);
    }

    pop() {
        return this.items.pop();
    }

    peek() {
        var len = this.items.length;
        return this.items[len-1];
    }

    /**
     * Returns whether or not this stack is empty.
     * @returns {boolean}
     */
    isEmpty() {
        if(this.items.length === 0){
            return "empty";
        }else{
            return "full!!";
        }
    }

    /**
     * Returns the size of this stack.
     * @returns {number} The length.
     */
    size() {
        return this.items.length;
    }
}



var stack = new Stack();
/* ====== MONDAYY ====== */
    // console.log(stack.isEmpty());

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    // stack.pop(1);
    // stack.pop(2);
    // stack.pop(3);
    // stack.pop(4);

    // stack.pop();

    console.log(stack.size());

    console.log(stack.isEmpty());   