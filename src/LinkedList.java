public class LinkedList {

    // Need a place to store the elements of the linked list;
    private static class Node {
        int data; //data to store at the current pointer
        Node next; // Self-instance of the node to point to the next node

        //Constructor:
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    /*
     *  For ADD_FRONT:
     * */
    // A head node:
    private Node head;

    public void addFront(int data) {
        //1. Create a new node:
        Node newNode = new Node(data);

        //2. Check if the Linked list is empty: ie; it is the 1st time we are adding any item to the linked list;
        if (head == null) {
            //Simply assign the newNode as head
            head = newNode;
            return;
        }

        //3. If there is node in the linked list and the head is not null, then set the newNode's next pointer to the current head:
        newNode.next = head; // Now head will become the 2nd node and newNode will be the head.

        //4. Set the current head simply point to the new node:
        head = newNode; // Now the head is newNode.

        // Time complexity is O(1).
    }


    /*
     *
     * For GET_FIRST:
     * */

    public int getFirst() {
        //Head is the 1st element of the linkedlist. So return the data of the head.
        //Check if the head is null:
        if (head==null){
            throw new IllegalStateException("Empty Linked List");
        }

        return head.data;
    }

    /*
     *
     * For GET_LAST:
     * */
    public int getLast(){
        if (head==null){
            throw new IllegalStateException("Empty Linked List");
        }

        //Create a temporary Node object and assign head to it.
        Node currentNode = head;
        //Loop through the linked list untill the currentNode points to the tail ie null:
        while (currentNode.next!=null){
            currentNode = currentNode.next; // time complexity = O(n);
        }

        //At last return the currentNode data.
        return currentNode.data;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }
}
