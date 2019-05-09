public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        System.out.println("before adding item: "+linkedList);
        linkedList.addFront(1);
        System.out.println("After adding 1st item: "+linkedList);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(3);
        System.out.println("After adding multiple item: "+linkedList);
        System.out.println("1st item: "+linkedList.getFirst());
        System.out.println("Last item: "+linkedList.getLast());


    }

}
