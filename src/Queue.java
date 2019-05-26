public class Queue {

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void add(int data) { // add item to queue from the tail
        Node newNode = new Node(data);

        if (tail != null) { // if there is a tail exist.
            // Remove the pointer of tail from null and point it to the newNode.
            tail.next = newNode;
        }
        // Make the newNode as the current tail.
        tail = newNode;

        //In case there is no head, ie; list is empty then assign the tail to the head-- the 1st element insertion.
        if (head == null) {
            head = tail;
        }
    }


    public int remove() { // Remove items from the head.

        // Save the data
        int data = head.data;
        // Point the head to the next element (effectively removing it)
        head = head.next;
        // Handle when the head is null -- make the tail also null.
        if (head == null) {
            tail = null;
        }
        // Then return the data
        return data;
    }


    public int peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void printStack(){
        Node currentNode = head;

        while (currentNode!=null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Queue");
        queue.printStack();

        System.out.println("Peeked:" + queue.peek());
        System.out.println("removed:" + queue.remove());
        System.out.println("Peeked:" + queue.peek());

        System.out.println("removed:" + queue.remove());
        System.out.println("removed:" + queue.remove());
        System.out.println("removed:" + queue.remove());
        System.out.println("removed:" + queue.remove());

        // No item to remove. So getting error.
//        System.out.println("removed:" + queue.remove());
//        System.out.println("removed:" + queue.remove());
//        System.out.println("removed:" + queue.remove());

        System.out.println("IsEmpty:" + queue.isEmpty());
    }
}
