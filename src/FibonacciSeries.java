public class FibonacciSeries {

    private int fib(int num){
        if (num==0){
            return 0;
        }else if (num==1){
            return 1;
        }else{
            return fib(num-1) + fib(num-2);
        }
    }

    private static long fibonacciLoop(long number){
        int first = 0;
        int second =1;
        int result =0;

        if (number==0 || number==1){
            return number;
        }

        for (int i = 2; i <= number; i++) {
            result = first + second;
            first = second;
            second = result;
            System.out.println(result);
        }

        return result;
    }

    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();

      //  System.out.println(fibonacciSeries.fib(200)); // Computation time is 2 sec and 510 ms.
        System.out.println(fibonacciLoop(50));
    }

}
