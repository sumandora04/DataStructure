public class Factorial {
    static int[] memo = new int[1024];

    private static int numberFactorialRec(int number) {
        if (number == 1) {
            //System.out.println(1);
            return 1;
        } else {
            //  System.out.println(number* numberFactorialRec(number-1));
            if (memo[number] == 0) {
                memo[number] = number * numberFactorialRec(number - 1);
                System.out.println(memo[number]);
            }
            return memo[number];
        }
    }

    private static int numberFactorialLoop(int number) {
        int factorial = 1;
        while (number != 1) {
            factorial = factorial * number;
            number = number - 1;

            System.out.println(factorial);
        }

        return factorial;
    }

    public static void main(String[] args) {
        // System.out.println(numberFactorialRec(5));
        System.out.println(numberFactorialLoop(5));
    }
}
