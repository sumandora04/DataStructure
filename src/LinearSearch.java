public class LinearSearch {
    private static void searchLinear(int[] array, int key){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==key){
                System.out.println(key+" found at index "+i);
               // break;
            }
        }


    }

    public static void main(String[] args) {
        int[] array = {1,6,23,67,89,45,23,4,5,7,89,71,9};
        searchLinear(array,89);
    }
}
