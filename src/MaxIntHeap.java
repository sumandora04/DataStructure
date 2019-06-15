import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxIntHeap {
    //Take some initial capacity
    private int capacity = 10;
    //Array size
    private int size = 0;
    //Array:
    int[] itemArray = new int[capacity];

    //Convert the binary heap tree into an array:
    //Get left child index:
    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    //Get right child index:
    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    //Get parent index:
    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    //Checking if any index have left/right index or parent exist:
    private boolean hasLeftChild(int index) {
        // if leftChildIndex < size then there is a left child, if it equals to size then no left child.
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        // if parentIndex >= 0 then there is a parent, if it is less than 0 then no parent exists.
        return parentIndex(index) >= 0;
    }

    //Getting the item at a particular index:
    private int leftChild(int index) {
        return itemArray[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return itemArray[rightChildIndex(index)];
    }

    private int parent(int index) {
        return itemArray[parentIndex(index)];
    }

    // Check the capacity of the array:
    private void ensureCapacity() {
        if (size == capacity) {
            itemArray = Arrays.copyOf(itemArray, capacity * 2);
            capacity = capacity * 2;
        }
    }

    //Swap function:
    private void swap(int firstIndex, int secondIndex) {
        int temp = itemArray[firstIndex];
        itemArray[firstIndex] = itemArray[secondIndex];
        itemArray[secondIndex] = temp;
    }

    //Heapify up:
    public void heapifyUp() {
        //Start at the last element:
        int index = size - 1;
        //While parent is less than the child, move upward to the next node of te parent:
        while (hasParent(index) && parent(index) < itemArray[index]) {
            //Swap the parent node with the current child
            swap(parentIndex(index), index);
            //walk upward to the next node in the tree:
            index = parentIndex(index);
        }
    }

    //Insert:
    public void insert(int item) {
        // check the array capacity:
        ensureCapacity();
        //Put the item at the last index:
        itemArray[size] = item;
        //Increase the size by 1:
        size++;
        //sort the binary tree:
        heapifyUp();
    }


    //Extract the max value:
    public int extractMax() {
        if (size == 0) throw new IllegalStateException();
        //Grab the max item:
        int maxItem = itemArray[0];
        //Swap the max value with the min value by over-writing the max value.
        itemArray[0] = itemArray[size - 1];
        //Decrease the size of the array to efficiently delete the last item:
        size--;
        //Now re-order the binary tree
        heapifyDown();

        //Return the max value:
        return maxItem;

    }

    private void heapifyDown() {
        ///Start at the top:
        int index = 0;

        //Loop as long as the index has a child:
        //Note: Only need to check the left child, because, if there is no left child then there is no right child:
        while (hasLeftChild(index)) {
            // take the larger child of the two left and right children:
            int smallerChildIndex = leftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                smallerChildIndex = rightChildIndex(index);
            }

            //Now compare them:
            //If current item is larger than the items of two children, then everything is good, and the tree is sorted:
            if (itemArray[index] > itemArray[smallerChildIndex]) {
                break;
            } else {
                //We need to re-order the  binary heap tree:
                swap(index, smallerChildIndex);
            }
            //Move down to the next child node:
            index = smallerChildIndex;
        }
    }

    //Printing the binary heap array:
    private void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + "[" + itemArray[i] + "]");
        }
    }

    public static void main(String[] args) {
        MaxIntHeap maxHeap = new MaxIntHeap();

        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);
        maxHeap.insert(14);
        maxHeap.insert(7);
        maxHeap.insert(18);
        maxHeap.insert(12);
        maxHeap.insert(11);
        maxHeap.insert(13);
        maxHeap.insert(35);

        maxHeap.print();

        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max value is:" + maxHeap.extractMax());
        maxHeap.print();

    }
}
