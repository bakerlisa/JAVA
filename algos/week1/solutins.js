removeBack() {
    if (this.isEmpty()) {
        return null;
    }

    // Only 1 node.
    if (this.head.next === null) {
        return this.removeHead();
    }

    // More than 1 node.
    let runner = this.head;

    while (runner.next.next) {
        runner = runner.next;
    }

    // after while loop finishes, runner is now at 2nd to last node
    const removedData = runner.next.data;
    runner.next = null; // remove it from list
    return removedData;
}

containsRecursive(val, current = this.head) {
    if (current === null) {
        return false;
    }
    if (current.data === val) {
        return true;
    }
    return this.containsRecursive(val, current.next);
}



recursiveMax(runner = this.head, maxNode = this.head) {
    if (this.head === null) {
        return null;
    }

    if (runner === null) {
        return maxNode.data;
    }

    if (runner.data > maxNode.data) {
        maxNode = runner;
    }

    return this.recursiveMax(runner.next, maxNode);
}