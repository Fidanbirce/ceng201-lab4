class MyStack {
    Node head, middle;
    int size;


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

            if (size % 2 != 0)
                middle = middle.prev;
        }
    }



    int pop() {
        if (size == 0)
            return -1;
        int val = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        size--;
        if (size % 2 == 0 && middle != null) {
            middle = middle.next;
        }
        return val;
    }



    int findMiddle() {
        if (middle == null)
            throw new RuntimeException("Empty stack");
        return middle.data;
    }



    void deleteMiddle() {
        if (size == 0)
            return;

        Node mid = middle;

        if (mid.prev != null)
            mid.prev.next = mid.next;
        if (mid.next != null)
            mid.next.prev = mid.prev;

        if (size % 2 == 0)
            middle = mid.next;
        else
            middle = mid.prev;

        size--;
    }
}




