public class HashTable {

    /*
     *  Hash-Table is an array of Linked-List elements.
     * */
    //Define an initial size for the array:
    private int INITIAL_SIZE = 16;

    //Create a Linked-List:
    class HashEntry {
        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null; // Initially list will be empty.
        }
    }

    //Create an array of type HashEntry linked-list:
    private HashEntry[] data;

    //Constructor for HashTable:
    HashTable() {
        //Initialise the array here:
        data = new HashEntry[INITIAL_SIZE];
    }


    /*
     *  Creating index for the key:
     * */

    private int getIndex(String key) {
        //1. Get the hash code for this "Key"
        int hashCode = key.hashCode();

        //2. Convert the hashCode into index:
//        int index = hashCode % INITIAL_SIZE; // This will give negative index - causes IndexOutOfBoundsException.
        // Bitwise operator (&) and 0x7fffffff will get the
        // 2s' complement of the index and convert it to positive number.
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        /*
         *  Hard-coding for collision:
         * */
        if (key.equals("ABC") || key.equals("DEF")) {
            index = 4;
        }

        //3. Return the index:
        return index;
    }


    /*
     *  Storing the key - value pair to the data array:
     * */
    private void put(String key, String value) {
        //1. Get the index for the key:
        int index = getIndex(key);

        //2. Create a linked-list entry for the key and value pair:
        HashEntry entry = new HashEntry(key, value); // ready to insert to the data array.

        //3. Check if the index already exist in the array?
        // 3.1: does not exist - a new data:
        if (data[index] == null) {
            data[index] = entry; // Storing the entry at that index.
        } else { //3.2: same index already exist -- collision occurred.
            // handle the collision by adding the entry to the end of the linked-list:

            System.out.println("Collision - - - BOOM....");

            //get the entries at that index from the data array:
            HashEntry allEntries = data[index];

            //Walk through the allEntries list - till end:
            while (allEntries.next != null) {
                allEntries = allEntries.next; // go to next and check
            }

            //Finally add the entry at the end:
            allEntries.next = entry;
        }
    }


    /*
     *  Look-up for the data:
     * */
    private String get(String key) {
        //1. Get the index for this "key":
        int index = getIndex(key);

        //2. Get current list of entries at that index in the data array:
        HashEntry allEntries = data[index];

        //3. If allEntries is not null and we have entries against this key:
        if (allEntries != null) {
            // Walk through the linked-list un-till the key is found and list end is not reached.
            while (!allEntries.key.equals(key) && allEntries.next != null) {
                allEntries = allEntries.next; // Go to next and check.
            }
            // finally return the value.
            return allEntries.value;
        }
        // 4. If no entry against the key is found:
        return null;
    }


    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put("Doremon", "1234567890");
        hashTable.put("Chhota-Bheem", "3465326356");
        hashTable.put("ABC", "1232343457");
        hashTable.put("DEF", "3465376846");

        System.out.println(hashTable.get("Doremon"));
        System.out.println(hashTable.get("Chhota-Bheem"));
        System.out.println(hashTable.get("ABC"));
        System.out.println(hashTable.get("DEF"));
    }
}
