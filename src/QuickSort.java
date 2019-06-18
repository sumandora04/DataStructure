import java.util.Arrays;

public class QuickSort {

    public int[] sort(int[] array){
        // 1. Pick a pivot element randomly
        /*
           2. Walk through the array making sure that all the elements
              are smaller before the pivot, and elements after are bigger than pivot.
              We do all this in the same array and no extra array is required. That's the killer feature.
        */
        // 3. Then we repeat the process to the left and right portions over and over again
        // 4. Then eventually our array becomes sorted.

        quickSort(array, 0 , array.length-1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        //1. Checking if the indices are overlapping or crossing:
        if (left>=right){
            return;
        }

        //2. Pick a pivot element -> we will choose the centre element:
        // Note: Better would be to choose left + (right-left)/2 (as this would avoid overflow error for large arrays i.e. 2GB))

        int pivot = array[(left+right)/2];

        //3. Partition the array around this pivot and return the index of the partition.
        int index = partition(array,left,right,pivot);

        //4. Sort on the left and right side recursively.
        quickSort(array,left,index-1); //Left side
        quickSort(array,index,right); //Right side
    }

    // Partition function.
    private int partition(int[] array, int left, int right, int pivot) {
        //1. Move the left and right pointers towards each other.
       while (left<=right){
           //2. Move the left pointer until you find an element bigger than the pivot
           while (array[left]<pivot){ //Left element is less than pivot then keep moving.
               left++;
           }
           //3. Move the right pointer until you find an element less than the pivot
           while (array[right]>pivot){ //Right element is more than pivot then keep moving.
               right--;
           }

           //4. Now we found elements larger and smaller than the pivot element. Swap them
           if (left<=right){
               swap(array,left,right);
               //Point the pointers to next positions.
               left++;
               right--;
           }
       }

       //5. Now at this point, everything in this partition will be in right order.
        // Now we need to return the next partition pointer, in our case it is "left".
       return left;
    }

    //Swap code:
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args) {
        int[] array = {0,1,0,1,0,1,0,1,0,1};
        QuickSort q = new QuickSort();
        System.out.println(Arrays.toString(q.sort(array)));
    }

}
