import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MultipleCharacterOccurrence {

    private static void removeAllDuplicate(String string){
        ArrayList<String> stringArray = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            stringArray.add(String.valueOf(string.charAt(i)));
        }

        Object[] objArr = stringArray.toArray();
        String[] strArr = Arrays.copyOf(objArr,objArr.length,String[].class);
        System.out.println(Arrays.toString(strArr));
        HashSet<String> hashSet = new HashSet<>(stringArray);
        System.out.println(hashSet);
    }

    private void removeDuplicate(String str) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 0;
            if (list.isEmpty()) {
                list.add("" + c);
            }
            if (!list.contains("" + c)) {
                list.add("" + c);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (String.valueOf(c).equals(list.get(j))) {
                        count++;
                    }
                }

                if (count < 2) {
                    list.add(String.valueOf(c));
                }
            }
        }

        System.out.println(list);
    }


    public static void main(String[] args) {
        MultipleCharacterOccurrence multipleCharacterOccurrence = new MultipleCharacterOccurrence();
      //  multipleCharacterOccurrence.removeDuplicate("AABCDABCCDABD");

        removeAllDuplicate("AABCDABCCDABD");

    }
}
