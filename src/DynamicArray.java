public class DynamicArray {
    private int initialCapacity;
    private int size;
    private Object[] data;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;

        data = new Object[initialCapacity];
        System.out.println("dataLength:"+data.length);
        System.out.println("initialCapacity:"+initialCapacity);
        size = data.length;
    }

    public void setData(int index, String value){
        data[index] = value;
    }

    public String getData(int index){
        return (String) data[index];
    }

    public void addData(String value){

        if (size==initialCapacity){
            resizeArray();
        }

        data[size]= value;
        size++;
    }

    private void resizeArray() {
        System.out.println("initial size before resize:"+initialCapacity);
        // new array with double the capacity of old array.
        Object[] newData = new Object[initialCapacity*2];
        //Copy all element from old array to the new array.
        // initial is not changed till now but the size have. so take the initial capacity for condition.
        for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }
        //Assign the new array to the old one:
        data = newData;

        // Update the initial capacity:
        initialCapacity = initialCapacity*2;
        System.out.println("initial size after resize:"+initialCapacity);
    }

    public void printArray(){
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.println("data :"+data[i]);
        }
    }

    public int getSize(){
        return data.length;
    }

    public void insertData(int index, String value){
        //Check the size and resize if required:
        if (size==initialCapacity){
            resizeArray();
        }
        //Copy up to make space for the item at that index:
        for (int i = size; i >index ; i--) {
            data[i] = data[i-1];
        }
        // insert the item at that index:
        data[index] = value;
        size++;

    }

    public void deleteItemAt(int index){
        for (int i = index; i <size ; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public boolean isArrayEmpty(){
        return size==0;
    }

   public boolean contains(String value){
       for (int i = 0; i < size; i++) {
           if (data[i].toString().equals(value)){
               return true;
           }
       }
       return false;
   }
}
