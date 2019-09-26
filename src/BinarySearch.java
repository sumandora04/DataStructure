public class BinarySearch {

    private static int binarySearchRec(int[] array, int key, int lowerIndex, int higherIndex) {
        int mid = 0;
        int found = -1;

        if (higherIndex >= lowerIndex) {
            mid = (lowerIndex + higherIndex) / 2;

            if (array[mid] == key) {
                found = mid;
            } else if (array[mid] > key) {
                return binarySearchRec(array, key, lowerIndex, mid - 1);
            } else {
                return binarySearchRec(array, key, mid + 1, higherIndex);
            }
        }
        return found;
    }


    private static int binarySearchLoop(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        int found = -1;
        while (high >= low) {
            mid = (high + low) / 2;

            if (array[mid] == key) {
                found = mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 8, 63, 64, 64, 69, 77};
        int position = binarySearchRec(array, 64, 0, array.length - 1);
        System.out.println(position);

        int position1 = binarySearchLoop(array, 63);
        System.out.println(position1);
    }
}
