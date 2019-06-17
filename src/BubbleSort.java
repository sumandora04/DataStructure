import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j]>array[j+1]){
                    //Swap these items:
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {122,7,1,25,9};

        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(unsortedArray)));
    }
}
