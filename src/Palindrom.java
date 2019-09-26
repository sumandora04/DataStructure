public class Palindrom {
    private static void checkPalindromNumber(int number){
        int temp = number;
        int reverse =0;
        while (temp>0){
            int remainder =0;
            remainder = temp%10;
            reverse = reverse*10+remainder;
            temp = temp/10;
        }
        System.out.println(reverse);
        if (number==reverse){
            System.out.println("Pallindrom");
        }else {
            System.out.println("Not Pallindrom");
        }
    }

    private static void checkStringPallindrom(String string){
        StringBuffer temp = new StringBuffer();
        temp.append(string);

        temp.reverse();

        if (string.equals(temp.toString())){
            System.out.println("Pallindrom string");
        }else {
            System.out.println("Not Pallindrom string");
        }
    }

    private static void checkStringPallindromNoLib(String string){
       // String[] array = new String[string.length()];
        StringBuilder strReverse = new StringBuilder();

        for (int i = string.length()-1; i >=0; i--) {
          //  array[i] = String.valueOf(string.charAt(i));
            strReverse.append(String.valueOf(string.charAt(i)));
        }

        if (string.equals(strReverse.toString())){
            System.out.println(string+" is pallindrom");
        }else {
            System.out.println(string+" is not pallindrom");
        }
    }

    public static void main(String[] args) {
        checkPalindromNumber(12343212);

        checkStringPallindrom("malayalam");

        checkStringPallindromNoLib("malayalam");
    }
}
