import java.util.ArrayList;

public class MultipleCharacterOccurrence {

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
        multipleCharacterOccurrence.removeDuplicate("AABCDABCCDABD");
    }
}
