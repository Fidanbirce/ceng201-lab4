class MyStack {
    Node head, middle;
    int size;

    // Push element on top of stack
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        size++;

        if (size == 1) {
            middle = newNode;
        } else {
            // Move middle back when size becomes odd
            if (size % 2 != 0)
                middle = middle.prev;
        }
    }

    // Pop top element
    int pop() {
        if (size == 0)
            throw new RuntimeException("Stack underflow");

        int val = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        size--;

        if (size != 0 && size % 2 == 0)
            middle = middle.next;

        return val;
    }

    // Get middle element
    int findMiddle() {
        if (middle == null)
            throw new RuntimeException("Empty stack");
        return middle.data;
    }

    // Delete middle element in O(1)
    void deleteMiddle() {
        if (size == 0)
            return;

        Node mid = middle;

        if (mid.prev != null)
            mid.prev.next = mid.next;
        if (mid.next != null)
            mid.next.prev = mid.prev;

        // Update middle pointer
        if (size % 2 == 0)
            middle = mid.next;
        else
            middle = mid.prev;

        size--;
    }
}




