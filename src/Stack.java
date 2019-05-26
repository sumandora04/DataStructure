import java.util.EmptyStackException;

public class Stack {

    private class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            this.next=null;
        }


    }

    private Node head;

    public void push(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

        } else {

            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }

        int data = head.data;

        head = head.next;
        return data;
    }


    public int peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void printStack() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack");
        stack.printStack();

        System.out.println("Peeked:" + stack.peek());
        System.out.println("Popped:" + stack.pop());
        System.out.println("Peeked:" + stack.peek());

        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());
        System.out.println("Popped:" + stack.pop());

        System.out.println("IsEmpty:" + stack.isEmpty());
    }
}
