public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(2);
        System.out.println("isArrayEmpty:"+array.isArrayEmpty());
        array.setData(0,"a");
        array.setData(1,"b");

        System.out.println(array.getData(0));
        System.out.println(array.getData(1));

        array.addData("c");
        array.addData("d");
        array.addData("e");
        array.addData("f");

        System.out.println("Before insertion");
        array.printArray();
        System.out.println("Size:"+array.getSize());

        array.insertData(2,"Hello");
        array.insertData(5,"Meow");
        array.insertData(7,"Bhow");
        System.out.println("After insertion");
        array.printArray();


        array.deleteItemAt(8);
        array.deleteItemAt(9);
        array.deleteItemAt(10);
        array.deleteItemAt(11);
        array.deleteItemAt(12);
        array.deleteItemAt(13);
        array.deleteItemAt(14);
        array.deleteItemAt(15);

        System.out.println("After deletion");
        array.printArray();
        System.out.println("Size After deletion:"+array.getSize());
        System.out.println("isArrayEmpty:"+array.isArrayEmpty());

        System.out.println("Contains:"+array.contains("Meow"));


    }
}
