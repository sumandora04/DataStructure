public class MergeSort {

    //Main function to sort the array, which in turn will call the merge() ;
    public void sort(int[] array, int left, int right){
        //if left< right then split the array... continue this process.
        if (left<right){
            int middle = (left+right)/2;

            //Sort the 1st and 2nd half:
            sort(array,left, middle); // The left half
            sort(array,middle+1, right); // The 2nd half

            //Merge the splited arrays:
            merge(array, left, middle,right);

        }
    }

    // Merge two sub-array of an array:
    // First sub-array is arr[left..middle]
    // Second sub-array is arr[middle+1..right]
    private void merge(int[] array, int left, int middle, int right) {
       // Find the size of the two sub arrays which are to be merged:
       int n1= middle-left +1;
       int n2 = right-middle;

       // Create the temporary arrays:
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Copy the data to the temporary arrays:
        for (int i = 0; i < n1; ++i) {
            L[i] = array[left+1];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = array[middle+1+j];
        }


        // Merge the temp arrays:
        //Initialise the initial size of the 1st and 2nd sub arrays:
        int i = 0; int j = 0;
        //The initial index of the merged array:
        int k = left;

        while (i<n1 && j<n2){
            // If item in L[] <= R[] then take the less value and put it in the array[]
            if (L[i]<= R[j]){
                array[k] = L[i];
                i++;
            }else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining item in L[] if any:
        while (i<n1){
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining item in R[] if any:
        while (j<n2){
            array[k] = R[j];
            j++;
            k++;
        }

        System.out.println("After Merge:");
        printArray(array);
    }

    private void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i <n; i++) {
            System.out.print(array[i]+" ");
           // System.out.println();
        }
    }


    public static void main(String[] args) {
        int array[] ={1,34,76,2,5,35,76,34};
        MergeSort m = new MergeSort();
        m.sort(array,0,array.length-1);
    }
}
