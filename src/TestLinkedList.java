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

        linkedList.addLast(123);
        System.out.println("Last item: "+linkedList.getLast());
        System.out.println("List size: "+linkedList.getListSize());

        linkedList.clearList();
        System.out.println("List size after clear: "+linkedList.getListSize());

        linkedList.addFront(11);
        linkedList.addLast(11);
        linkedList.addLast(33);
        linkedList.addLast(44);
        linkedList.addLast(55);
        linkedList.addLast(44);

        System.out.println("After adding multiple item: "+linkedList);

        linkedList.deleteValue(11);
        System.out.println("After delete 11: "+linkedList);

        linkedList.deleteValue(44);
        System.out.println("After delete 44: "+linkedList);

        linkedList.deleteValue(55);
        System.out.println("After delete 55: "+linkedList);
    }

}
