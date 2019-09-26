public class SumOfDigits {
    private static void numberSum(int number) {
        int sum = 0;
        while (number > 0) {
            int remainder = 0;
            remainder = number % 10;
            sum = sum + remainder;
            number = number / 10;
        }
        if (sum>9){
            numberSum(sum);
        }
        System.out.println(sum);
     //   sumChecker(sum);
    }

    private static void sumChecker(int sum){
        if (sum>9){
            numberSum(sum);
        }
    }

    public static void main(String[] args) {
        SumOfDigits.numberSum(1237);
    }
}
